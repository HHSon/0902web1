package helloworld.util;

public class Numbers {
	
	public static int getInt(String number, int defaultValue) {
		if (number == null)
			return defaultValue;
			
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException ex) {
			return defaultValue;
		}
	}
	
	public static float getFloat(String number, float defaultValue) {
		if (number == null)
			return defaultValue;
			
		try {
			return Float.parseFloat(number);
		} catch (NumberFormatException ex) {
			return defaultValue;
		}
	}
}
