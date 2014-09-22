package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class InvoiceRestController extends AbstractRestController {
	private static final Logger LOGGER = Logger.getLogger(InvoiceRestController.class);

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "/{store}/invoice/{id}", method = RequestMethod.GET)
	public Invoice get(
			@PathVariable("store") String store,
			@PathVariable("id") long id,
			@RequestParam(required = false) String mql
	) throws Exception {
		return invoiceService.get(id);
	}

	@RequestMapping(value = "/{store}/invoice", method = RequestMethod.GET)
	public List<Invoice> getAll(
			@PathVariable("store") String store,
			@RequestParam(required = false) String mql
	) throws Exception {
		return invoiceService.getAll();
	}

	@RequestMapping(value = "/{store}/invoice/insert", method = RequestMethod.POST)
	public Invoice insert(
			@PathVariable("store") String store,
			Invoice insertObj
	) throws Exception {
		return invoiceService.insert(insertObj);
	}

	@RequestMapping(value = "/{store}/invoice/update", method = RequestMethod.PUT)
	public Invoice update(
			@PathVariable("store") String store,
			Invoice updateObj
	) throws Exception {
		return invoiceService.update(updateObj);
	}

	@RequestMapping(value = "/{store}/invoice/delete/{id}", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			@PathVariable("id") long objId
	) throws Exception {
		invoiceService.delete(objId);
	}

	@RequestMapping(value = "/{store}/invoice/delete", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			Invoice deleteObj
	) throws Exception {
		invoiceService.delete(deleteObj);
	}
}
