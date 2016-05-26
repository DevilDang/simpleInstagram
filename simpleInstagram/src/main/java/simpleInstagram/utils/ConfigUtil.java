package simpleInstagram.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConfigUtil {

	public static void init() {

		loadLogConfig();

	}
	/**
	 * load log configure file from resource
	 */
	static public void loadLogConfig() {
		Logger logger = Logger.getLogger(ConfigUtil.class);
		String log4JPropertyFile = "log.properties";
		Properties p = new Properties();

		try {
			p.load(ConfigUtil.class.getClassLoader().getResourceAsStream(log4JPropertyFile));
			PropertyConfigurator.configure(p);
			logger.info("Wow! Finished load configured log !");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

}
