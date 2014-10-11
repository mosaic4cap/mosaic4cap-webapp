package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.chefui.controller.StoreCache;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 24.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceDefinitionsTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceDefinitionsTest.class);

	@Autowired
	private InvoiceDefinitions definitions;

	@Test
	public void canGetAllInvoicesInAContainer() throws Exception {
		StoreCache.get().setStoreId(1);
		List<InvoiceContainer> invoiceContainers = definitions.getAllInvoices();
		assertThat(invoiceContainers.size(), is(1));
	}
}
