package de.mosaic4cap.webapp.stereotypes.domain;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lobedan on 22.09.2014.
 */
@RunWith(JUnit4.class)
public class InvoiceContainerTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceContainerTest.class);

	private InvoiceContainer container;

	@Before
	public void setup() {
		/*List<Invoice> partials = new ArrayList<>();

		List<double> billList = new ArrayList<>();
		billList.add(new double(10.20));
		billList.add(new double(4.12));

		List<double> ecList = new ArrayList<>();
		ecList.add(new double(10.24));
		ecList.add(new double(4.95));
		partials.add(new Invoice(new double(300), billList, ecList, null, null, null, null));

		billList.add(new double(50));
		ecList.remove(1);
		partials.add(new Invoice(new double(300), billList, ecList, null, null, null, null));

		billList.remove(1);
		billList.remove(0);
		partials.add(new Invoice(new double(300), billList, ecList, null, null, null, null));

		billList.clear();
		ecList.clear();
		partials.add(new Invoice(new double(300), billList, ecList, null, null, null, null));

		container = new InvoiceContainer(new Date(), partials, null);*/
		container = new InvoiceContainer(new Date(), null, null);
	}

	@Test
	public void canComputeAmounts() throws Exception {
		assertThat(container.getAmount(), is(calcIn(container.getPartials())));
		assertThat(container.getEcAmount(), is(calcEC(container.getPartials())));
		assertThat(container.getBillAmount(), is(calcBill(container.getPartials())));
	}

	private double calcIn(List<Invoice> l) {
		double sum = 0.00;
		for (Invoice s : l) {
			sum += s.getIncome();
		}
		return sum;
	}

	private double calcEC(List<Invoice> l) {
		double sum = 0.00;
		for (Invoice s : l) {
			sum += s.getECAmount();
		}
		return sum;
	}

	private double calcBill(List<Invoice> l) {
		double sum = 0.00;
		for (Invoice s : l) {
			sum += s.getBillAmount();
		}
		return sum;
	}
}
