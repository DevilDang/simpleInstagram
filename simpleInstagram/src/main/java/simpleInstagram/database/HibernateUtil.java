package simpleInstagram.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static public void init() {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			Class.forName("com.mysql.jdbc.Driver");
			Configuration configuration = new Configuration().configure();
			ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
			registry.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * Closes the current SessionFactory and releases all resources.
	 * <p>
	 * The only other method that can be called on HibernateUtil after this one
	 * is rebuildSessionFactory(Configuration).
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
		// Clear static variables
		sessionFactory = null;
	}

}
