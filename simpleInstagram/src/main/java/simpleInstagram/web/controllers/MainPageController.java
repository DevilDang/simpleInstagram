package simpleInstagram.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import simpleInstagram.utils.CommonUtils;

@Controller
public class MainPageController {

	private Logger logger = Logger.getLogger(MainPageController.class);
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadMultipleFiles(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        String url;
        String storedFolderLocation = CommonUtils.createStoredFolder(request);
        logger.debug(storedFolderLocation);
            String uploadedFileName = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
 
                String storedFileLocation = storedFolderLocation + File.separator + uploadedFileName;
                
                logger.debug(storedFileLocation);
                File serverFile = new File(storedFileLocation);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                url = CommonUtils.getDomainName(request)
                        + "/simpleInstagram/resources/uploads/" + uploadedFileName;
               
                return url;
 
            } catch (Exception e) {
                e.printStackTrace();
            }
			return uploadedFileName;
	}

}
