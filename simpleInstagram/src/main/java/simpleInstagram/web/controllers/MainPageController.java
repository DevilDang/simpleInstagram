package simpleInstagram.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import simpleInstagram.web.businessobject.HandleFileUpload;
import simpleInstagram.web.datamodel.FileUploadedInfo;

@Controller
public class MainPageController {

	private Logger logger = Logger.getLogger(MainPageController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public FileUploadedInfo uploadMultipleFiles(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) {

		FileUploadedInfo fileInfos = null;
		try {
			fileInfos = HandleFileUpload.saveFileUpload(file, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}

		return fileInfos;

	}

}
