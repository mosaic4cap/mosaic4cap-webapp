package de.mosaic4cap.webapp.chefui.definitions;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.chefui.services.notification.Notification;
import de.mosaic4cap.webapp.chefui.services.notification.NotificationService;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by svenklemmer on 17.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ModelDefinitionsTest {
    private static final Logger LOGGER = Logger.getLogger(ModelDefinitionsTest.class);

    @Autowired
    private ModelDefinitions modelDefinitions;

    @Autowired
    private NotificationService notificationService;

    @Test
    public void canGetNotificationList() throws Exception {
        List<Notification> notifications = modelDefinitions.getNotifications();
        Collections.sort(notifications);

        List<Notification> no = notificationService.getAll();
        Collections.sort(no);

        assertEquals(notifications, no);
    }

    @Ignore
    public void canGetAllStores() throws Exception {
        List<Object> l = new ArrayList<>();
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        assertEquals(l, modelDefinitions.getAllStores());
    }
}
