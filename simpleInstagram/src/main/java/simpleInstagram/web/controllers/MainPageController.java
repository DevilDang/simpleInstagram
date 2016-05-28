package simpleInstagram.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import simpleInstagram.database.modelenity.PhotoFeed;
import simpleInstagram.web.businessobject.HandleFileUpload;
import simpleInstagram.web.businessobject.PhotoFeedBo;
import simpleInstagram.web.datamodel.Feed;
import simpleInstagram.web.datamodel.FeedInfo;
import simpleInstagram.web.datamodel.FileUploadedInfo;
import simpleInstagram.web.datamodel.ResponseMesage;

@Controller
public class MainPageController {

	private Logger logger = Logger.getLogger(MainPageController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public FileUploadedInfo uploadMultipleFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		FileUploadedInfo fileInfos = null;
		try {
			fileInfos = HandleFileUpload.saveFileUpload(file, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		return fileInfos;

	}

	@RequestMapping(value = "/getListPhotoFeed", method = RequestMethod.POST)
	@ResponseBody
	public List<FeedInfo> getListPhotoFeed(HttpServletRequest request) {

		PhotoFeedBo bo = new PhotoFeedBo();
		List<FeedInfo> photoFeed = null;
		try {
			photoFeed = bo.getListPhotoFeed(request);
			return photoFeed;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoFeed;

	}

	@RequestMapping(value = "/createNewPhotoFeed", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMesage createNewPhotoFeed(@RequestBody Feed feed,
			HttpServletRequest request) {

		logger.debug(feed);
		PhotoFeed newPhotoFeed = new PhotoFeed();
		newPhotoFeed.setDescription(feed.getDescription());
		newPhotoFeed.setImagePath(feed.getUploadedFilename());

		PhotoFeedBo bo = new PhotoFeedBo();
		String email = (String) request.getSession().getAttribute("user");
		try {
			if (bo.createNewPhotoFeed(newPhotoFeed, email)) {
				logger.debug("Create Photofeed Success");
				return new ResponseMesage("success", "Create Photofeed Success");
			} else {
				logger.debug("Create Photofeed fail");
				return new ResponseMesage("fail", "Create Photofeed Fail");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return  new ResponseMesage("fail", e.getMessage());

		}

	}

}
