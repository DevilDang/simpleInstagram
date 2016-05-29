package simpleInstagram.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import simpleInstagram.web.businessobject.PhotoFeedBo;
import simpleInstagram.web.datamodel.response.FeedInfo;

@Controller
public class HashtagController {

	
	@RequestMapping(value = { "/hashtagresult" }, method = RequestMethod.GET)
	public ModelAndView renderProfilePage(@RequestParam String hashtag,HttpServletRequest request) {

		String email = (String) request.getSession().getAttribute("user");
		
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("userLogged", email);
		map.put("hashtag",hashtag);
		
		return new ModelAndView("hashtagresult", map);
	}
	
	@RequestMapping(value = "/searchForHashTag", method = RequestMethod.GET)
	@ResponseBody
	public List<FeedInfo> searchForHashTag(@RequestParam String hashtag,HttpServletRequest request) {

		PhotoFeedBo bo = new PhotoFeedBo();
		List<FeedInfo> photoFeed = null;
		try {
			photoFeed = bo.searchForHashTag("#"+hashtag,request);
			return photoFeed;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoFeed;

	}
}
