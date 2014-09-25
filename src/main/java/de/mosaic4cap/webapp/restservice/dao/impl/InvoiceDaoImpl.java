package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.InvoiceDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class InvoiceDaoImpl extends HibernateDao<Invoice, Long> implements InvoiceDao { }
