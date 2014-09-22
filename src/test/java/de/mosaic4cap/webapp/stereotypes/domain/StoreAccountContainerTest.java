package de.mosaic4cap.webapp.stereotypes.domain;

import de.mosaic4cap.webapp.stereotypes.entities.StoreAccount;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lobedan on 22.09.2014.
 */
@RunWith(JUnit4.class)
public class StoreAccountContainerTest {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountContainerTest.class);

    private StoreAccountContainer container;

    @Before
    public void setup() {
        List<StoreAccount> partials = new ArrayList<>();

        List<BigDecimal> billList = new ArrayList<>();
        billList.add(new BigDecimal(10.20));
        billList.add(new BigDecimal(4.12));

        List<BigDecimal> ecList = new ArrayList<>();
        ecList.add(new BigDecimal(10.24));
        ecList.add(new BigDecimal(4.95));
        partials.add(new StoreAccount(new BigDecimal(300), billList, ecList, null, null, null, null));

        billList.add(new BigDecimal(50));
        ecList.remove(1);
        partials.add(new StoreAccount(new BigDecimal(300), billList, ecList, null, null, null, null));

        billList.remove(1);
        billList.remove(0);
        partials.add(new StoreAccount(new BigDecimal(300), billList, ecList, null, null, null, null));

        billList.clear();
        ecList.clear();
        partials.add(new StoreAccount(new BigDecimal(300), billList, ecList, null, null, null, null));

        container = new StoreAccountContainer(new Date(), partials, null);
    }

    @Test
    public void canComputeAmounts() throws Exception {
        assertThat(container.getAmount(), is(calcIn(container.getPartials())));
        assertThat(container.getECAmount(), is(calcEC(container.getPartials())));
        assertThat(container.getBillAmount(), is(calcBill(container.getPartials())));
    }

    private BigDecimal calcIn(List<StoreAccount> l) {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : l)
            sum = sum.add(s.getIncome());
        return sum;
    }

    private BigDecimal calcEC(List<StoreAccount> l) {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : l)
            sum = sum.add(s.getECAmount());
        return sum;
    }

    private BigDecimal calcBill(List<StoreAccount> l) {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : l)
            sum = sum.add(s.getBillAmount());
        return sum;
    }
}
