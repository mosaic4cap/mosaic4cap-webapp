package de.mosaic4cap.webapp.chefui.definitions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.chefui.services.notification.Notification;
import de.mosaic4cap.webapp.chefui.services.notification.NotificationService;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by svenklemmer on 17.09.14.
 * <p>
 * This class hold methods which are injected into templates by spring's
 * {@link org.springframework.web.bind.annotation.ModelAttribute} because there are template fragments
 * inside every template e.g header, footer, this class is annotadet with
 * {@link org.springframework.web.bind.annotation.ControllerAdvice} to make them accessable by every
 * controller in this application
 * <p>
 * See: #3
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

	@ModelAttribute(value = "allInvoices")
	public List<InvoiceContainer> getAllInvoices() {
		List<Invoice> partials = new ArrayList<>();

		List<BigDecimal> billList = new ArrayList<>();
		billList.add(new BigDecimal(10.20));
		billList.add(new BigDecimal(4.12));

		List<BigDecimal> ecList = new ArrayList<>();
		ecList.add(new BigDecimal(10.24));
		ecList.add(new BigDecimal(4.95));
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.add(new BigDecimal(50));
		ecList.remove(1);
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.remove(1);
		billList.remove(0);
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.clear();
		ecList.clear();
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		List<InvoiceContainer> invoiceContainers = new ArrayList<>();
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));
		return invoiceContainers;
	}
}
