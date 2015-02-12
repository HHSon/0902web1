package helloworld.common.config;

import helloworld.util.Numbers;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class Configuration {
	/**
	* Config file
	*/
	static final String INTERNAL_CONFIG_FILE = "helloworld.properties";
	
	/**
	* Config values in program
	*/
	private static String projectName;
	private static String projectVersion;
	private static String javaVersion;
	private static int logStoredDuration;
	
	
	private Configuration() {
		throw new UnsupportedOperationException();
	}
	
	public static void loadConfig() {
		logger.info("Loading configuration ..");
		
		Properties properties = new Properties();
		ClassLoader classLoader = Configuration.class.getClassLoader();		
		
		try {
			InputStream inputStream = classLoader.getResourceAsStream(INTERNAL_CONFIG_FILE);		
			if (inputStream == null) {
				logger.error("Cannot find the " + INTERNAL_CONFIG_FILE);
				return;
			}
			properties.load(inputStream);
		} catch (IOException ex) {
			logger.error("Cannot load " + INTERNAL_CONFIG_FILE, ex);
			return;
		}
		
		loadConfigElements(properties);
		
		logger.info("Loaded configuration successfully");
	}
	
	private static void loadConfigElements(Properties properties) {
		projectName = properties.getProperty(ConfigElement.ProjectName.key());
		projectVersion = properties.getProperty(ConfigElement.ProjectVersion.key());
		javaVersion = properties.getProperty(ConfigElement.JavaVersion.key());
		
		logStoredDuration = Numbers.getInt(
				properties.getProperty(ConfigElement.LogStoredDuration.key()),
				(Integer)ConfigElement.LogStoredDuration.defaultValue());
	}
	
	public static String getProjectName() {
		return projectName;
	}
	
	public static String getProjectVersion() {
		return projectVersion;
	}
	
	public static String getJavaVersion() {
		return javaVersion;
	}
	
	public static int getLogStoredDuration() {
		return logStoredDuration;
	}
	
	private static final Logger logger = LogManager.getLogger(Configuration.class);
}
