package de.mosaic4cap.webapp.chefui.definitions;

import de.mosaic4cap.webapp.chefui.services.notification.Notification;
import de.mosaic4cap.webapp.chefui.services.notification.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svenklemmer on 17.09.14.
 * <p/>
 * This class hold methods which are injected into templates by spring's
 * {@link org.springframework.web.bind.annotation.ModelAttribute} because there are template fragments
 * inside every template e.g header, footer, this class is annotadet with
 * {@link org.springframework.web.bind.annotation.ControllerAdvice} to make them accessable by every
 * controller in this application
 * <p/>
 * TODO: Split file into several separated definitions
 */
@ControllerAdvice
public class ModelDefinitions {
    private static final Logger LOGGER = Logger.getLogger(ModelDefinitions.class);

    @Autowired
    private NotificationService notificationService;

    @ModelAttribute(value = "notifications")
    public List<Notification> getNotifications() throws Exception {
        return notificationService.getAll();
    }

    @ModelAttribute(value = "allStores")
    public List getAllStores() {
        List<Object> l = new ArrayList<>();
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        return l;
    }
}
