package simpleInstagram.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import simpleInstagram.web.businessobject.PhotoFeedBo;
import simpleInstagram.web.datamodel.response.CommentInfo;
import simpleInstagram.web.datamodel.response.FeedInfo;
import simpleInstagram.web.datamodel.response.ResponseMesage;

@Controller
public class PhotoFeedController {

	private static final Logger logger = Logger.getLogger(PhotoFeedController.class);

	@RequestMapping(value = { "/photofeed" }, method = RequestMethod.GET)
	public ModelAndView rennderPhotoFeedPage(@RequestParam String feedId, HttpServletRequest request) {

		Map<String, String> models = new HashMap<String, String>();
		models.put("photoFeedID", feedId);
		String email = (String) request.getSession().getAttribute("user");
		models.put("userLogged", email);
		
		return new ModelAndView("photofeed", models);
	}
	
	@RequestMapping(value = "/getPhotoFeed", method = RequestMethod.GET)
	@ResponseBody
	public FeedInfo getPhotoFeed(@RequestParam String photoFeedID, HttpServletRequest request) {
		
		PhotoFeedBo bo = new PhotoFeedBo();
		
		try {
			FeedInfo feedInfo = bo.getFeedInfo(photoFeedID, request);
			return feedInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMesage addComment(@RequestParam String content,@RequestParam String photoFeedId, HttpServletRequest request) {
		
		PhotoFeedBo bo = new PhotoFeedBo();
		
		String email = (String) request.getSession().getAttribute("user");
		try {
			if(bo.addComment(content, photoFeedId, email)){
				return new ResponseMesage("success", "add commnet success");
			}else{
				return new ResponseMesage("fail", "add commnet fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			return new ResponseMesage("fail", e.getMessage());
		}
		

	}
	
	
	@RequestMapping(value = "/getListComments", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentInfo> getListComments(@RequestParam String photoFeedID,HttpServletRequest request) {

		PhotoFeedBo bo = new PhotoFeedBo();
		List<CommentInfo> CommentInfos = null;
		try {
			CommentInfos = bo.getListComments(photoFeedID,request);
			return CommentInfos;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommentInfos;

	}
	
	
	
	

}
