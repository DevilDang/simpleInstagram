package simpleInstagram.web.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.PhotoFeedDaoImpl;
import simpleInstagram.database.dao.impl.UserDaoImpl;
import simpleInstagram.database.enumtype.OrderType;
import simpleInstagram.database.modelenity.PhotoFeed;
import simpleInstagram.database.modelenity.User;
import simpleInstagram.utils.CommonUtils;
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

	public List<FeedInfo> getListPhotoFeed(HttpServletRequest request) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			PhotoFeedDaoImpl dao = new PhotoFeedDaoImpl(session);

			List<PhotoFeed> listphotofeed = dao.findAll("updateDate", OrderType.DESCENDING.name());
			List<FeedInfo> listFeedInfo = new ArrayList<FeedInfo>();
			for (int i = 0; i < listphotofeed.size(); i++) {
				User user = listphotofeed.get(i).getUser();
				String imgUrl = CommonUtils.getUrlUploadFolder(request) + listphotofeed.get(i).getImagePath();
				String description = listphotofeed.get(i).getDescription();

				listFeedInfo.add(new FeedInfo(user.getName(), description, imgUrl));
			}

			return listFeedInfo;
		} catch (Exception e) {
			e.printStackTrace();

			throw e;

		} finally {
			session.close();
		}
	}

}
