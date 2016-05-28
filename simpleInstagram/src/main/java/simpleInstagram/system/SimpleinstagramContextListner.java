package simpleInstagram.system;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.PooledDataSource;

import simpleInstagram.database.HibernateUtil;
import simpleInstagram.utils.ConfigUtil;

public class SimpleinstagramContextListner implements ServletContextListener{
	private static final Logger logger = Logger.getLogger(SimpleinstagramContextListner.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("Application context being destroyed...");
		try {
			closeC3P0DataSources();
		} catch (Exception ignored) {
		}

		try {
			deregisterJDBC();
		} catch (Exception ignored) {
		}

		try {
			HibernateUtil.shutdown();
		} catch (Exception ignored) {
		}

	
		try {
			logger.info("Sleep and wait for database shutdown by itself");
			// FIXME not a precise method!!
			// However, even if the thread is not killed before i awake, the
			// thread should finish it work
			// before JVM stops
			Thread.sleep(1000);
			logger.info("Wake up");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	



	private void closeC3P0DataSources() {
		C3P0Registry .getNumPooledDataSources();

		@SuppressWarnings({ "unchecked", "rawtypes" })
		Iterator<Set<PooledDataSource>> it = C3P0Registry.getPooledDataSources().iterator();
		while (it.hasNext()) {
			try {
				PooledDataSource dataSource = (PooledDataSource) it.next();
				dataSource.close();
			} catch (Exception e) {
				logger.error("", e);
			}
		}
	}

	private void deregisterJDBC() {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Driver d = null;
		while (drivers.hasMoreElements()) {
			try {
				d = drivers.nextElement();
				DriverManager.deregisterDriver(d);
				logger.warn(String.format("Driver %s deregistered", d));
			} catch (SQLException ex) {
				logger.warn(String.format("Error deregistering driver %s", d), ex);
			}
		}
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
		for (Thread t : threadArray) {
			if (t.getName().contains("Abandoned connection cleanup thread")) {
				synchronized (t) {
					t.stop(); // don't complain, it works
				}
			}
		}
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
