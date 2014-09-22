package de.mosaic4cap.webapp.chefui.services.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;

import static org.junit.Assert.assertEquals;

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
	List<Notification> notificationList = new ArrayList<>();
	notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test2", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test3", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test4", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test5", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test6", "TestMessage", new Date()));
	notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test7", "TestMessage", new Date()));
	Collections.sort(notificationList);

	List<Notification> no = service.getAll();
	Collections.sort(no);

	assertEquals(no, notificationList);
 }
}

