package de.mosaic4cap.webapp.restservice.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.restservice.dao.InvoiceDao;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceDaoImplTest extends GenericHibernateDaoTestCase {
	private static final Logger LOGGER = Logger.getLogger(InvoiceDaoImplTest.class);

	@Autowired
	private InvoiceDao invoiceDao;

	@Test
	@Override
	public void testCreate() throws Exception {
		Invoice entity = new Invoice(new BigDecimal(1), null, null, null, null, null, new Date());

		Invoice returnValue = invoiceDao.create(entity);
		assertEquals(returnValue, entity);
	}

	@Test
	@Override
	public void testRetrieve() throws Exception {
		Invoice setupEntity = invoiceDao
				.create(new Invoice(new BigDecimal(2), null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		assertNotNull(invoiceDao.retrieve(setupEntity.getId()));
	}

	@Test
	@Override
	public void testRetrieveAll() throws Exception {
		Invoice setupEntity = invoiceDao
				.create(new Invoice(new BigDecimal(3), null, null, null, null, null, new Date()));
		Invoice setupEntity2 = invoiceDao
				.create(new Invoice(new BigDecimal(4), null, null, null, null, null, new Date()));
		Invoice setupEntity3 = invoiceDao
				.create(new Invoice(new BigDecimal(5), null, null, null, null, null, new Date()));
		Invoice setupEntity4 = invoiceDao
				.create(new Invoice(new BigDecimal(6), null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);
		assertNotNull(setupEntity2);
		assertNotNull(setupEntity3);
		assertNotNull(setupEntity4);

		assertNotNull(invoiceDao.retrieveAll());
	}

	@Test
	@Override
	public void testMerge() throws Exception {
		Invoice setupEntity = invoiceDao
				.create(new Invoice(new BigDecimal(7), null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);
		setupEntity.setIncome(new BigDecimal(12));

		Invoice updatedEntity = invoiceDao.merge(setupEntity);
		assertEquals(updatedEntity, setupEntity);
	}

	@Test
	@Override
	public void testRemoveByObject() throws Exception {
		Invoice setupEntity = invoiceDao
				.create(new Invoice(new BigDecimal(8), null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		invoiceDao.remove(setupEntity);
		assertNull(invoiceDao.retrieve(setupEntity.getId()));
	}

	@Test
	@Override
	public void testRemoveById() throws Exception {
		Invoice setupEntity = invoiceDao
				.create(new Invoice(new BigDecimal(9), null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		invoiceDao.remove(setupEntity.getId());
		assertNull(invoiceDao.retrieve(setupEntity.getId()));
	}
}
