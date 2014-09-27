package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lobedan on 22.09.2014.
 */
@RunWith(JUnit4.class)
public class InvoiceTest {
	private static final Logger LOGGER = Logger.getLogger(InvoiceTest.class);

	@Test
	public void canComputeECAndBillAmount() throws Exception {
		Set<Double> billList = new HashSet<>();
		billList.add(10.20);
		billList.add(4.12);

		Set<Double> ecList = new HashSet<>();
		ecList.add(10.24);
		ecList.add(4.95);
		Invoice sA = new Invoice(300.00, billList, ecList, null, null, null, null);

		assertThat(sA.getBillAmount(), is(calc(billList)));
		assertThat(sA.getECAmount(), is(calc(ecList)));

		billList.add(50.00);
		ecList.remove(10.24);
		sA.setBills(billList);
		sA.setEcpayment(ecList);
		assertThat(sA.getBillAmount(), is(calc(billList)));
		assertThat(sA.getECAmount(), is(calc(ecList)));

		billList.remove(10.20);
		billList.remove(4.12);
		sA.setBills(billList);
		sA.setEcpayment(ecList);
		assertThat(sA.getBillAmount(), is(calc(billList)));
		assertThat(sA.getECAmount(), is(calc(ecList)));

		billList.clear();
		ecList.clear();
		sA.setBills(billList);
		sA.setEcpayment(ecList);
		assertThat(sA.getBillAmount(), is(calc(billList)));
		assertThat(sA.getECAmount(), is(calc(ecList)));
	}

	private double calc(Set<Double> l) {
		double sum = 0.00;
		for (double d : l) {
			sum += d;
		}
		return sum;
	}
}
