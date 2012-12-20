package ro.andonescu.demos.springmvcfreemarker.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String DEFAULT_DATE_FORMAT = "dd.MM.yyyy";

	private DateUtil() {

	}

	public static String getFormat(Date date) {
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
	}

	public static String getFormat(Date date, String datePattern) {
		return new SimpleDateFormat(datePattern).format(date);
	}
}
