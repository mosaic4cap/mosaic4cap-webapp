package de.mosaic4cap.webapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.format.Formatter;

/**
 * Created by svenklemmer on 19.09.14.
 * <p/>
 * Simple DateFormatter useable by Thymeleaf for dateformatting
 */
public class DateFormatter implements Formatter<Date> {
 private static final Logger LOGGER = Logger.getLogger(DateFormatter.class);

 //@Autowired
 //private MessageSource messageSource;

 public DateFormatter() {
	super();
 }

 @Override
 public Date parse(final String text, final Locale locale) throws ParseException {
	final SimpleDateFormat dateFormat = createDateFormat();
	return dateFormat.parse(text);
 }

 @Override
 public String print(final Date object, final Locale locale) {
	final SimpleDateFormat dateFormat = createDateFormat();
	return dateFormat.format(object);
 }

 private SimpleDateFormat createDateFormat() {
	final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	dateFormat.setLenient(false);
	return dateFormat;
 }
}