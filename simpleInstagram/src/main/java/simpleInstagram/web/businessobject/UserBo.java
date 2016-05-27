package simpleInstagram.web.businessobject;

import org.hibernate.Session;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.UserDaoImpl;
import simpleInstagram.database.modelenity.User;

public class UserBo {
	
   public boolean authenticate(String email,String password){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			UserDaoImpl dao = new UserDaoImpl(session);

			boolean flag = dao.authenticate(email, password);

			return flag;

		} catch (Exception e) {
			e.printStackTrace();

			if (session.isOpen())
				session.getTransaction().rollback();

		} finally {
			session.close();
		}
		return false;
   }
   
   public boolean createUser(User user) throws Exception{
	   Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			UserDaoImpl dao = new UserDaoImpl(session);

			User persitUser = dao.makePersistent(user);

			session.getTransaction().commit();
			
			if(persitUser != null)
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

}
