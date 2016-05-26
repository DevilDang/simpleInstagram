package simpleInstagram.database.dao.impl;

import org.hibernate.Session;

import simpleInstagram.database.dao.ExtendedGenericDao;
import simpleInstagram.database.modelenity.PhotoFeed;

public class PhotoFeedDaoImpl extends ExtendedGenericDao<PhotoFeed, Long> {

	public PhotoFeedDaoImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

}
