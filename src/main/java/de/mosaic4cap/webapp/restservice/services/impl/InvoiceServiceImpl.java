package de.mosaic4cap.webapp.restservice.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.restservice.dao.InvoiceDao;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class InvoiceServiceImpl extends AbstractGenericService<Invoice> implements InvoiceService {
 private static final Logger LOGGER = Logger.getLogger(InvoiceServiceImpl.class);

 public InvoiceServiceImpl() {
 }

 @Autowired
 public InvoiceServiceImpl(InvoiceDao dao) {
	super.setDao(dao);
 }
}
