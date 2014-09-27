package de.mosaic4cap.webapp.restservice.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.InvoiceRepository;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class InvoiceService extends BaseRestService<Invoice, Long> implements IInvoiceService {
	private static final Logger LOGGER = Logger.getLogger(InvoiceService.class);

	@Autowired
	public void setRepository(InvoiceRepository repo) {
		super.setRepository(repo);
	}
}
