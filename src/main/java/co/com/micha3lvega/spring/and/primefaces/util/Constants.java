package co.com.micha3lvega.spring.and.primefaces.util;

import java.util.TimeZone;

public class Constants {

	private Constants() {
		throw new IllegalStateException("Utility class");
	}

	public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("America/New_York");

}
