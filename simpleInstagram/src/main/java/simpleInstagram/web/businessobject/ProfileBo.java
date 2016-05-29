package simpleInstagram.web.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.database.dao.impl.FollowRelationshipDaoImpl;
import simpleInstagram.database.dao.impl.UserDaoImpl;
import simpleInstagram.database.modelenity.PhotoFeed;
import simpleInstagram.database.modelenity.User;
import simpleInstagram.utils.CommonUtils;
import simpleInstagram.web.datamodel.response.FeedInfo;
import simpleInstagram.web.datamodel.response.Profile;

public class ProfileBo {

	public Profile getProfile(HttpServletRequest request) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			UserDaoImpl userDao = new UserDaoImpl(session);
			FollowRelationshipDaoImpl followRelationDao = new FollowRelationshipDaoImpl(session);

			User user = userDao.getUser((String) request.getSession().getAttribute("user"));

			int countPostFeed = user.getPhotofeeds().size();
			int countFollower = followRelationDao.countFollower(user.getId());
			int countFollowing = followRelationDao.countFollowing(user.getId());

			Profile profile = new Profile(user.getName(), user.getEmail(), countPostFeed, countFollower,
					countFollowing);

			return profile;

		} catch (Exception e) {
			e.printStackTrace();

			throw e;

		} finally {
			session.close();
		}

	}

	public List<FeedInfo> getListPostFeeds(HttpServletRequest request) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			UserDaoImpl userDao = new UserDaoImpl(session);

			User user = userDao.getUser((String) request.getSession().getAttribute("user"));

			Set<PhotoFeed> photoFeeds = user.getPhotofeeds();
			List<FeedInfo> listFeedInfo = new ArrayList<FeedInfo>();
			for (PhotoFeed photoFeed : photoFeeds) {

				String imgUrl = CommonUtils.getUrlUploadFolder(request) + photoFeed.getImagePath();
				Long feedId = photoFeed.getId();
				FeedInfo feedInfo = new FeedInfo(user.getName(), photoFeed.getDescription(), imgUrl, feedId);
				listFeedInfo.add(feedInfo);
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
