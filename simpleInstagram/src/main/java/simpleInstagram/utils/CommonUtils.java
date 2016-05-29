package simpleInstagram.utils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import simpleInstagram.web.controllers.MainPageController;

public class CommonUtils {

	private static Logger logger = Logger.getLogger(CommonUtils.class);
	
	public static String URL_UPLOAD_FOLDER;
	public static String DOMAIN_NAME;

	public static String createStoredFolder(HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String relativePath = "resources"+ File.separator+ "uploads";
		String storedFolderLocation = realPath + relativePath;
		File dir = new File(storedFolderLocation);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return storedFolderLocation;
	}

	public static boolean isFileTypeImage(String fileName) {
		String imagePattern = "([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)";
		return Pattern.compile(imagePattern).matcher(fileName).matches();

	}

	public static String getDomainName(HttpServletRequest request) {

		if (DOMAIN_NAME == null)
			DOMAIN_NAME = request.getProtocol().toLowerCase().replaceAll("[0-9./]", "") + "://"
					+ request.getServerName() + ":" + request.getServerPort();
		return DOMAIN_NAME;

	}

	public static String getUrlUploadFolder(HttpServletRequest request) {

		if (URL_UPLOAD_FOLDER == null) {
			URL_UPLOAD_FOLDER = CommonUtils.getDomainName(request) +  "simpleInstagram/resources/uploads/";

		}

		return URL_UPLOAD_FOLDER;

	}
	
	public static String replaceHashtag(String description){
		//String str="#important thing in #any programming #7#& ";
		//System.out.println(description.replace("#important", "a"));
		Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
		Matcher matcher = MY_PATTERN.matcher(description);
		
		while (matcher.find()) {
		  String tag = matcher.group(0);
		  String tag1 = matcher.group(1);
		  description = description.replace(tag, "<a href=\"hashtagresult?hashtag="+tag1+"\">"+tag+"</a>");
		  
		}
		
		logger.debug(description);
		
		return description;
		
	}

}
