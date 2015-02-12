package helloworld.common.config;

public enum ConfigElement {
	
	ProjectName ("project.name", "hellworld"),
	ProjectVersion ("project.version", "unknown"),
	JavaVersion ("java.version", "unknown"),
	LogStoredDuration("log.storedDuration", new Integer(10));
	
	
	private String key;
	private Object defaultValue;
	
	ConfigElement(String key, Object defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}
	
	public String key() {
		return key;
	}
	
	public Object defaultValue() {
		return defaultValue;
	}
}
