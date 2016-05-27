package simpleInstagram.database.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import simpleInstagram.database.dao.ExtendedGenericDao;
import simpleInstagram.database.modelenity.User;

public class UserDaoImpl extends ExtendedGenericDao<User, Long> {

	public UserDaoImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	public User getUser(String email) {

		String queryString = "Select user from User user where email=:email";
		Query query = getSession().createQuery(queryString);

		query.setString("email", email);

		User user = (User) query.uniqueResult();

		return user;

	}

	public boolean authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
