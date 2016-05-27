package simpleInstagram.system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.utils.CommonUtils;
import simpleInstagram.utils.ConfigUtil;

public class SimpleinstagramContextListner implements ServletContextListener{
	private static final Logger logger = Logger.getLogger(SimpleinstagramContextListner.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	
		try {
			ConfigUtil.init();
			// TODO Auto-generated method stub
			logger.info("===================================");
			logger.info("Initializing application context...");
			
			
			HibernateUtil.init();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to initialise system context", e);
		}
			
		
		
	}

}
