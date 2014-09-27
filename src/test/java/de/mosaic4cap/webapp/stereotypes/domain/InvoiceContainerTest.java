package de.mosaic4cap.webapp.stereotypes.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		List<Invoice> partials = new ArrayList<>();

		Set<Double> billList = new HashSet<>();
		billList.add(10.20);
		billList.add(4.12);

		Set<Double> ecList = new HashSet<>();
		ecList.add(10.24);
		ecList.add(4.95);
		partials.add(new Invoice(300.00, billList, ecList, null, null, null, null));

		billList.add(50.25);
		ecList.remove(4.95);
		partials.add(new Invoice(300.00, billList, ecList, null, null, null, null));

		billList.remove(10.20);
		partials.add(new Invoice(300.00, billList, ecList, null, null, null, null));

		billList.clear();
		ecList.clear();
		partials.add(new Invoice(300.00, billList, ecList, null, null, null, null));

		container = new InvoiceContainer(new Date(), partials, null);
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
