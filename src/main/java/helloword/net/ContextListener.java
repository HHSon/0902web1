package helloworld.net;

import helloworld.common.config.Configuration;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ContextListener implements ServletContextListener {
	
	private Logger logger = LogManager.getLogger(ContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("Starting application ..");
		Configuration.loadConfig();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("Context destroyed");
	}
}
