package simpleInstagram.utils;

import java.io.File;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	public static String createStoredFolder(HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String relativePath = "resources\\uploads";
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
		return request.getProtocol().toLowerCase().replaceAll("[0-9./]", "") + "://" + request.getServerName() + ":"
				+ request.getServerPort();
	}

}