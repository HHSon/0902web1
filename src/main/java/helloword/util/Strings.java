package helloworld.util;

public class Strings {
	
	public static boolean isBlank(String s) {
		return (s == null) || s.isEmpty();
	}
	
	public static boolean isNotBlank(String s) {
		if (s == null || s.isEmpty())
			return false;
		return true;
	}
}
