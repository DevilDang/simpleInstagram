package simpleInstagram.database.dao.impl;

import org.hibernate.Session;

import simpleInstagram.database.dao.ExtendedGenericDao;
import simpleInstagram.database.modelenity.Comments;

public class CommentsDaoImpl extends ExtendedGenericDao<Comments, Long> {

	public CommentsDaoImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

}
