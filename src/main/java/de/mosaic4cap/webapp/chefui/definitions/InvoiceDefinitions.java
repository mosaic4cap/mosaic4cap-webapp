package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.chefui.controller.StoreCache;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.utils.JSONUtil;

/**
 * Created by Lobedan on 24.09.2014.
 *
 * ControllerAdvice to push invoicedata of a store directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.services.InvoiceService} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 */
@ControllerAdvice
public class InvoiceDefinitions implements Definitions {
	private static final Logger LOGGER = Logger.getLogger(InvoiceDefinitions.class);

	@Autowired
	private InvoiceService service;

	private List<InvoiceContainer> globalList;

	@ModelAttribute(value = "allInvoices") //TODO: add parameters to access different stores
	public List<InvoiceContainer> getAllInvoices() throws Exception {
		return service.getGroupedInvoices(StoreCache.get().getStoreId());
	}

	@ModelAttribute(value = "allInvoicesJSON") //TODO: add parameters to access different stores
	public String getAllInvoicesASJson() throws Exception {
//		List<InvoiceContainer> list =  service.getGroupedInvoices(1);
		return JSONUtil.toJson(service.getGroupedInvoices(StoreCache.get().getStoreId()));
	}
}
