package simpleInstagram.web.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.CommentsDaoImpl;
import simpleInstagram.database.dao.impl.PhotoFeedDaoImpl;
import simpleInstagram.database.dao.impl.UserDaoImpl;
import simpleInstagram.database.enumtype.OrderType;
import simpleInstagram.database.modelenity.Comments;
import simpleInstagram.database.modelenity.PhotoFeed;
import simpleInstagram.database.modelenity.User;
import simpleInstagram.utils.CommonUtils;
import simpleInstagram.web.datamodel.CommentInfo;
import simpleInstagram.web.datamodel.FeedInfo;

public class PhotoFeedBo {

	public boolean createNewPhotoFeed(PhotoFeed photoFeed, String email) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			PhotoFeedDaoImpl dao = new PhotoFeedDaoImpl(session);
			UserDaoImpl userDao = new UserDaoImpl(session);

			photoFeed.setUser(userDao.getUser(email));

			PhotoFeed feed = dao.makePersistent(photoFeed);

			session.getTransaction().commit();

			if (feed != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

			throw e;

		} finally {
			session.close();
		}

	}

	public List<FeedInfo> getListPhotoFeed(HttpServletRequest request) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			PhotoFeedDaoImpl dao = new PhotoFeedDaoImpl(session);

			List<PhotoFeed> listphotofeed = dao.findAll("updateDate", OrderType.DESCENDING.name());
			List<FeedInfo> listFeedInfo = new ArrayList<FeedInfo>();
			for (int i = 0; i < listphotofeed.size(); i++) {
				User user = listphotofeed.get(i).getUser();
				String imgUrl = CommonUtils.getUrlUploadFolder(request) + listphotofeed.get(i).getImagePath();
				String description = listphotofeed.get(i).getDescription();
				Long feedId = listphotofeed.get(i).getId();

				listFeedInfo.add(new FeedInfo(user.getName(), description, imgUrl, feedId));
			}

			return listFeedInfo;
		} catch (Exception e) {
			e.printStackTrace();

			throw e;

		} finally {
			session.close();
		}
	}

	public FeedInfo getFeedInfo(String photoFeedID, HttpServletRequest request) throws Exception{

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			PhotoFeedDaoImpl dao = new PhotoFeedDaoImpl(session);

			PhotoFeed feed = dao.getById(Long.valueOf(photoFeedID), false);

			String username = feed.getUser().getName();
			String description = feed.getDescription();
			String imgUrl = CommonUtils.getUrlUploadFolder(request) + feed.getImagePath();
			;
			Long feedId = feed.getId();

			List<CommentInfo> listCommentInfos = new ArrayList<CommentInfo>();
			Set<Comments> comments = feed.getCommnents();
			for (Comments comment : comments) {
				listCommentInfos.add(new CommentInfo(comment.getUser().getName(), comment.getContent()));
			}

			FeedInfo feedInfo = new FeedInfo(username, description, imgUrl, feedId);
			feedInfo.setComments(listCommentInfos);

			return feedInfo;
		} catch (Exception e) {
			e.printStackTrace();

			throw e;

		} finally {
			session.close();
		}


	}
	
	public boolean addComment(String content,String photoFeedId,String email) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			
			CommentsDaoImpl dao = new CommentsDaoImpl(session);
			PhotoFeedDaoImpl photoFeeddao = new PhotoFeedDaoImpl(session);
			UserDaoImpl userDao = new UserDaoImpl(session);
			
			Comments comment = new Comments();
			comment.setContent(content);
			comment.setPhotoFeed(photoFeeddao.getById(Long.parseLong(photoFeedId), false));
			comment.setUser(userDao.getUser(email));
			
			Comments persit = dao.makePersistent(comment);
			
			session.getTransaction().commit();

			if (persit != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

			throw e;

		} finally {
			session.close();
		}
	}
	
	
	public List<CommentInfo> getListComments(String photoFeedID,HttpServletRequest request) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			PhotoFeedDaoImpl photoFeedDao = new PhotoFeedDaoImpl(session);
			
			PhotoFeed feed = photoFeedDao.getById(Long.parseLong(photoFeedID), false);
			Set<Comments> comments =  feed.getCommnents();
			
			List<CommentInfo> listCommentInfo = new ArrayList<CommentInfo>();
			for (Comments comment : comments) {
				User user = comment.getUser();
				String content = comment.getContent();

				listCommentInfo.add(new CommentInfo(user.getName(),content ));
			}

			return listCommentInfo;
		} catch (Exception e) {
			e.printStackTrace();

			throw e;

		} finally {
			session.close();
		}
	}


}
