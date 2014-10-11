package de.mosaic4cap.webapp.chefui.definitions;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.chefui.services.notification.NotificationService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by svenklemmer on 17.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class NotificationDefinitionsTest {
	private static final Logger LOGGER = Logger.getLogger(NotificationDefinitionsTest.class);

	@Autowired
	private NotificationDefinitions definitions;

	@Autowired
	private NotificationService notificationService;

	@Test
	public void canGetNotificationList() throws Exception {
		assertThat(notificationService.getAll().size(), is(definitions.getNotifications().size()));
	}
}
