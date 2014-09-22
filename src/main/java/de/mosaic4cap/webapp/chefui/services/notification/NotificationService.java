package de.mosaic4cap.webapp.chefui.services.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseService;

/**
 * Created by svenklemmer on 19.09.14.
 * <p>
 * Controller returning all data needed by application to display
 * notification properly
 * <p>
 * getAll method only gets all Notifications with hasRead = false
 * on hover those objects will set hasRead to true
 */
@Service
public class NotificationService extends BaseService<Notification> {
	private static final Logger LOGGER = Logger.getLogger(NotificationService.class);

	@Override
	public Notification put(Notification obj) throws Exception {
		return super.put(obj);
	}

	@Override
	public List<Notification> getAll() throws Exception {
		List<Notification> notificationList = new ArrayList<>();
		notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test2", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test3", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test4", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.STOREACCOUNT, "Test5", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test6", "TestMessage", new Date()));
		notificationList.add(new Notification(NotificationType.DEPLOYMENT, "Test7", "TestMessage", new Date()));
		return notificationList;
	}
}
