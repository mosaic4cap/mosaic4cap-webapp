package de.mosaic4cap.webapp.stereotypes.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
 public void canComputeECAmount() throws Exception {
	List<BigDecimal> billList = new ArrayList<>();
	billList.add(new BigDecimal(10.20));
	billList.add(new BigDecimal(4.12));

	List<BigDecimal> ecList = new ArrayList<>();
	ecList.add(new BigDecimal(10.24));
	ecList.add(new BigDecimal(4.95));
	Invoice sA = new Invoice(new BigDecimal(300), billList, ecList, null, null, null, null);

	assertThat(sA.getBillAmount(), is(calc(billList)));
	assertThat(sA.getECAmount(), is(calc(ecList)));

	billList.add(new BigDecimal(50));
	ecList.remove(1);
	sA.setBills(billList);
	sA.setEcpayment(ecList);
	assertThat(sA.getBillAmount(), is(calc(billList)));
	assertThat(sA.getECAmount(), is(calc(ecList)));

	billList.remove(1);
	billList.remove(0);
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

 private BigDecimal calc(List<BigDecimal> l) {
	BigDecimal sum = new BigDecimal(0);
	for (BigDecimal d : l) {
	 sum = sum.add(d);
	}
	return sum;
 }
}
