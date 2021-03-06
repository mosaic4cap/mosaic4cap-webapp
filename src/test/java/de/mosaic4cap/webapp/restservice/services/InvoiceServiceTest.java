package de.mosaic4cap.webapp.restservice.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 27.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceServiceTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceServiceTest.class);

	@Autowired
	private InvoiceService service;

	@Test
	public void canGetAllInvoicesByStoreIdSuccess() throws Exception {
		List<Invoice> invoiceList = service.getAllByStoreId(2);
		assertThat(invoiceList.size(), is(3));
		invoiceList.forEach(i -> assertThat(i.getStore().getId(), is(2L)));
	}

	@Test
	public void canGetAllInvoicesByStoreIdFailure() throws Exception {
		List<Invoice> invoiceList = service.getAllByStoreId(5);
		assertThat(invoiceList.size(), is(0));
	}

	@Test
	public void canGroupAvailableInvoicesSuccess() throws Exception {
		List<InvoiceContainer> containers = service.getGroupedInvoices(1);
		assertThat(containers, notNullValue());
		assertThat(containers.size(), is(1));
	}

	@Test
	public void canGroupAvailableInvoicesFailure() throws Exception {
		List<InvoiceContainer> containers = service.getGroupedInvoices(4);
		assertThat(containers.size(), is(0));
	}

  @Test(expected = IllegalArgumentException.class)
  public void canUpdateMultipleNullInvoices() throws Exception {
    List<Invoice> invoices = new ArrayList<>();
    invoices.add(null);
    invoices.add(null);
    service.updateInvoices(invoices);
  }

  @Test
  public void canUpdateMultipleEmptyInvoices() throws Exception {
    List<Invoice> invoices = service.updateInvoices(new ArrayList<>());
    assertThat(invoices.size(), is(0));
  }

  @Test
  public void canUpdateMultipleInvoices() throws Exception {
    List<InvoiceContainer> containers = service.getGroupedInvoices(1);
    assertThat(containers, notNullValue());
    assertThat(containers.size(), is(1));

    List<Invoice> invoices = containers.get(0).getPartials();
    assertThat(invoices, notNullValue());
    assertThat(invoices.size(), is(3));

    Invoice voice = invoices.get(0);
    invoices.remove(voice);
    voice.setIncome(12312.10);
    invoices.add(voice);

    List<Invoice> updated = service.updateInvoices(invoices);
    assertThat(updated.size(), is(invoices.size()));
  }
}
