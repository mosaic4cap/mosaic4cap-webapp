package de.mosaic4cap.webapp.restservice.services.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceServiceImplTest extends GenericServiceTestCase {

	private static final Logger LOGGER = Logger.getLogger(InvoiceServiceImplTest.class);

	@Autowired
	private InvoiceService invoiceService;

	@Test
	@Override
	public void testInsert() throws Exception {
		Invoice entity = new Invoice(1.00, null, null, null, null, null, new Date());

		Invoice returnValue = invoiceService.insert(entity);
		assertEquals(returnValue, entity);
	}

	@Test
	@Override
	public void testGet() throws Exception {
		Invoice setupEntity = invoiceService
				.insert(new Invoice(2.00, null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		assertNotNull(invoiceService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testGetAll() throws Exception {
		Invoice setupEntity = invoiceService
				.insert(new Invoice(3.00, null, null, null, null, null, new Date()));
		Invoice setupEntity2 = invoiceService
				.insert(new Invoice(4.00, null, null, null, null, null, new Date()));
		Invoice setupEntity3 = invoiceService
				.insert(new Invoice(5.00, null, null, null, null, null, new Date()));
		Invoice setupEntity4 = invoiceService
				.insert(new Invoice(6.00, null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);
		assertNotNull(setupEntity2);
		assertNotNull(setupEntity3);
		assertNotNull(setupEntity4);

		assertNotNull(invoiceService.getAll());
	}

	@Test
	@Override
	public void testUpdate() throws Exception {
		Invoice setupEntity = invoiceService
				.insert(new Invoice(7.00, null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);
		setupEntity.setIncome(1234.00);

		Invoice updatedEntity = invoiceService.update(setupEntity);
		assertEquals(updatedEntity, setupEntity);
	}

	@Test
	@Override
	public void testDeleteByObject() throws Exception {
		Invoice setupEntity = invoiceService
				.insert(new Invoice(8.00, null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		invoiceService.delete(setupEntity);
		assertNull(invoiceService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testDeleteById() throws Exception {
		Invoice setupEntity = invoiceService
				.insert(new Invoice(9.00, null, null, null, null, null, new Date()));
		assertNotNull(setupEntity);

		invoiceService.delete(setupEntity.getId());
		assertNull(invoiceService.get(setupEntity.getId()));
	}
}

