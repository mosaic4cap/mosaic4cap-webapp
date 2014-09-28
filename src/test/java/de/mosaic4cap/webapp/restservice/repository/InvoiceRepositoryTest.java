package de.mosaic4cap.webapp.restservice.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 27.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceRepositoryTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceRepositoryTest.class);

	@Autowired
	private InvoiceRepository repository;

	@Test
	public void canGetInvoicesByStoreIdSuccess() throws Exception {
		List<Invoice> invoiceList = repository.findByStoreId(1L);
		assertThat(invoiceList.size(), is(3));
		invoiceList.forEach(i -> assertThat(i.getStore().getId(), is(1L)));
	}

	@Test
	public void canGetInvoicesByStoreIdFailure() throws Exception {
		List<Invoice> invoiceList = repository.findByStoreId(10L);
		assertThat(invoiceList.size(), is(0));
	}
}
