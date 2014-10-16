package de.mosaic4cap.webapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Lobedan on 21.09.2014.
 */
@RunWith(JUnit4.class)
public class DateFormatterTest {
	private static final Logger LOGGER = Logger.getLogger(DateFormatterTest.class);

	private DateFormatter dateFormatter;

	@Before
	public void setup() {
		dateFormatter = new DateFormatter();
	}

	@Test
	public void canParseDate() throws Exception {
		SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
		Date d = new Date();
		String txt = sd.format(d);
		assertThat(sd.parse(txt), is(dateFormatter.parse(txt, Locale.ENGLISH)));
	}

	@Test
	public void canPrintDate() throws Exception {
		Date d = new Date();
		assertThat(new SimpleDateFormat("dd.MM.yyyy").format(d), is(dateFormatter.print(d, Locale.ENGLISH)));
	}


}
