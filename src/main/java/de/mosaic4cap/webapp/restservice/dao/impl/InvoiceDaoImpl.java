package de.mosaic4cap.webapp.restservice.dao.impl;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.restservice.dao.InvoiceDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class InvoiceDaoImpl extends GenericHibernateDaoImpl<Invoice> implements InvoiceDao {
 private static final Logger LOGGER = Logger.getLogger(InvoiceDaoImpl.class);
}
