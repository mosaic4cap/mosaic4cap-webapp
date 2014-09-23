package de.mosaic4cap.webapp.chefui.definitions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Lobedan on 24.09.2014.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
public class InvoiceDefinitionsTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceDefinitionsTest.class);

	@Autowired
	private InvoiceDefinitions definitions;

	//	@Test
	public void canGetAllInvoices() throws Exception {
		List<Invoice> partials = new ArrayList<>();

		List<BigDecimal> billList = new ArrayList<>();
		billList.add(new BigDecimal(10.20));
		billList.add(new BigDecimal(4.12));

		List<BigDecimal> ecList = new ArrayList<>();
		ecList.add(new BigDecimal(10.24));
		ecList.add(new BigDecimal(4.95));
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.add(new BigDecimal(50));
		ecList.remove(1);
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.remove(1);
		billList.remove(0);
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		billList.clear();
		ecList.clear();
		partials.add(new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null));

		List<InvoiceContainer> invoiceContainers = new ArrayList<>();
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));
		invoiceContainers.add(new InvoiceContainer(new Date(), partials, null));

		assertThat(invoiceContainers, is(definitions.getAllInvoices()));
	}
}
