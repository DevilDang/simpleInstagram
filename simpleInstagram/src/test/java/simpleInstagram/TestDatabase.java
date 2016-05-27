package simpleInstagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.CommentsDaoImpl;
import simpleInstagram.database.dao.impl.PhotoFeedDaoImpl;
import simpleInstagram.database.dao.impl.UserDaoImpl;
import simpleInstagram.database.enumtype.OrderType;
import simpleInstagram.database.modelenity.Comments;
import simpleInstagram.database.modelenity.PhotoFeed;
import simpleInstagram.database.modelenity.User;
import simpleInstagram.utils.ConfigUtil;

public class TestDatabase {

	@Test
	public void init() {
		ConfigUtil.init();
		HibernateUtil.init();

		 createUser();
		// createPhotoFeed();
		//getListPhoToFeed("dangtanloc2304@gamil.com");
		//createComments();
		//getListMostPhotoFeed();
		// getListCommentsOfaFeed();

	}

	public void createUser() {

		User user1 = new User();

		user1.setEmail("dangtanloc2304@gmail.com");
		user1.setName("Dang Tan Loc");
		user1.setPassword("123456");

		User user2 = new User();

		user2.setEmail("tanloc@donahitech.vn");
		user2.setName("Dang Tan");
		user2.setPassword("123456");

		User user3 = new User();

		user3.setEmail("thienhoang@donahitech.vn");
		user3.setName("Nguyen Thien Hoang");
		user3.setPassword("123456");

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);

			 dao.makePersistent(user1);
			 dao.makePersistent(user2);
			//dao.makePersistent(user3);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}

	}

	public void createComments() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);
			CommentsDaoImpl commentsdao = new CommentsDaoImpl(session);
			
			User user1 = dao.getUser("dangtanloc2304@gamil.com");
//			User user2 = dao.getUser("tanloc@donahitech.vn");
			User user3 = dao.getUser("thienhoang@donahitech.vn");
			
			Set<PhotoFeed> feeds = user1.getPhotofeeds();
			int count  = 4;
			for(PhotoFeed feed :feeds){
				Comments comment = new Comments();
				comment.setContent("it is nice picture " + ++count);
				comment.setUser(user3);
				comment.setPhotoFeed(feed);
				
				commentsdao.makePersistent(comment);
			}
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	public void createPhotoFeed() {

		PhotoFeed feed1 = new PhotoFeed();
		feed1.setDescription("Test test test");
		feed1.setImagePath("C:/upload/test1.png");

		PhotoFeed feed2 = new PhotoFeed();
		feed2.setDescription("Test test test");
		feed2.setImagePath("C:/upload/test2.png");

		PhotoFeed feed3 = new PhotoFeed();
		feed3.setDescription("Test test test");
		feed3.setImagePath("C:/upload/test3.png");

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);
			PhotoFeedDaoImpl feedDao = new PhotoFeedDaoImpl(session);

			User user = dao.getUser("dangtanloc2304@gamil.com");
			feed1.setUser(user);
			feed2.setUser(user);
			feed3.setUser(user);

			feedDao.makePersistent(feed1);
			feedDao.makePersistent(feed2);
			feedDao.makePersistent(feed3);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	public void getListPhoToFeed(String email) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);

			User user = dao.getUser("dangtanloc2304@gamil.com");

			Set<PhotoFeed> feeds = user.getPhotofeeds();

			System.out.println(feeds.size());
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}

	}

	
	public void getListCommentsOfaFeed(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);
			
			User user = dao.getUser("dangtanloc2304@gamil.com");

			Set<PhotoFeed> feeds = user.getPhotofeeds();
			List<PhotoFeed> listfeed = new ArrayList<PhotoFeed>(feeds);
			
			Set<Comments> comments = listfeed.get(0).getCommnents();
			
			for(Comments comment: comments){
				System.out.println(comment.getContent());
			}
			

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}
	
	public void getListMostPhotoFeed() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			
			PhotoFeedDaoImpl dao = new PhotoFeedDaoImpl(session);
			
			List<PhotoFeed> listfeed = dao.findAll("updateDate",OrderType.DESCENDING.name());
			for(int  i = 0;i<listfeed.size();i++){
				System.out.println(listfeed.get(i).getUpdateDate());
			}
			

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}

	}

	

}
