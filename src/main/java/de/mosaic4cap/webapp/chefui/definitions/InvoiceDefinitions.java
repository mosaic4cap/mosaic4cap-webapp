package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;

/**
 * Created by Lobedan on 24.09.2014.
 *
 * ControllerAdvice to push invoicedata of a store directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.controller.InvoiceRestController} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 */
@ControllerAdvice
public class InvoiceDefinitions implements Definitions {
	private static final Logger LOGGER = Logger.getLogger(InvoiceDefinitions.class);

	@ModelAttribute(value = "allInvoices")
	public List<InvoiceContainer> getAllInvoices() {
		/*List<Invoice> partials = new ArrayList<>();

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
		return invoiceContainers;**/
    return null;
	}
}
