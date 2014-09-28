package de.mosaic4cap.webapp.chefui.services.notification;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by svenklemmer on 19.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class NotificationServiceTest {
	private static final Logger LOGGER = Logger.getLogger(NotificationServiceTest.class);

	@Autowired
	private NotificationService service;

	@Test
	public void canGetAllNotifications() throws Exception {
		assertThat(service.getAll().size(), is(7));
	}
}

