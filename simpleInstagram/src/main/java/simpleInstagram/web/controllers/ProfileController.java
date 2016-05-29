package simpleInstagram.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import simpleInstagram.web.businessobject.PhotoFeedBo;
import simpleInstagram.web.businessobject.ProfileBo;
import simpleInstagram.web.datamodel.response.CommentInfo;
import simpleInstagram.web.datamodel.response.FeedInfo;
import simpleInstagram.web.datamodel.response.Profile;

@Controller
public class ProfileController {

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public ModelAndView renderProfilePage(HttpServletRequest request) {

		String email = (String) request.getSession().getAttribute("user");
		return new ModelAndView("profile", "userLogged", email);
	}
	
	@RequestMapping(value = "/getProfile", method = RequestMethod.GET)
	@ResponseBody
	public Profile getProfile( HttpServletRequest request) {
		
		ProfileBo bo = new ProfileBo();
		
		try {
			Profile profile = bo.getProfile(request);
			return profile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/getListPostFeeds", method = RequestMethod.GET)
	@ResponseBody
	public List<FeedInfo> getListComments(HttpServletRequest request) {

		ProfileBo bo = new ProfileBo();
		List<FeedInfo> listFeedInfo = null;
		try {
			listFeedInfo = bo.getListPostFeeds(request);
			return listFeedInfo;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listFeedInfo;

	}

}
