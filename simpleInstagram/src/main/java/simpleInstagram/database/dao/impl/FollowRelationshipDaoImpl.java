package simpleInstagram.database.dao.impl;

import org.hibernate.Session;

import simpleInstagram.database.dao.GenericDao;
import simpleInstagram.database.modelenity.FollowRelationship;

public class FollowRelationshipDaoImpl extends GenericDao<FollowRelationship, Long> {

	public FollowRelationshipDaoImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}
	
	public int countFollower(Long userid){
		return 0;
	}
	
	public int countFollowing(Long userid){
		return 0;
	}

}
