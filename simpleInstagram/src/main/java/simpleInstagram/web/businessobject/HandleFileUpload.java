package simpleInstagram.web.businessobject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import simpleInstagram.utils.CommonUtils;
import simpleInstagram.web.controllers.MainPageController;
import simpleInstagram.web.datamodel.FileUploadedInfo;

public class HandleFileUpload {

	private static Logger logger = Logger.getLogger(MainPageController.class);

	public static FileUploadedInfo saveFileUpload(MultipartFile file, HttpServletRequest request) throws Exception {
		String storedFolderLocation = CommonUtils.createStoredFolder(request);
		logger.debug(storedFolderLocation);
		String uploadedFileName = file.getOriginalFilename();
		uploadedFileName = System.currentTimeMillis() + uploadedFileName;
		try {
			byte[] bytes = file.getBytes();

			String storedFileLocation = storedFolderLocation + File.separator + uploadedFileName;

			logger.debug(storedFileLocation);
			File serverFile = new File(storedFileLocation);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			String url = CommonUtils.getDomainName(request) + "/simpleInstagram/resources/uploads/" + uploadedFileName;

			FileUploadedInfo fileInfo = new FileUploadedInfo(uploadedFileName, url);
		

			return fileInfo;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			throw e;
		}
	}

}
