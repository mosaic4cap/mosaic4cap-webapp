package de.mosaic4cap.webapp.stereotypes.domain;

import de.mosaic4cap.webapp.stereotypes.entities.Store;
import de.mosaic4cap.webapp.stereotypes.entities.StoreAccount;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Lobedan on 22.09.2014. *
 * <p/>
 * Container for storeaccount objects with some buisnesslogic in it
 */
public class StoreAccountContainer extends Container {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountContainer.class);

    private Date date;
    private List<StoreAccount> partials;
    private Store store;

    public StoreAccountContainer() {
    }

    public StoreAccountContainer(Date pDate, List<StoreAccount> pPartials, Store pStore) {
        date = pDate;
        partials = pPartials;
        store = pStore;
    }

    public BigDecimal getECAmount() {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : partials) {
            for (BigDecimal b : s.getEcpayment()) {
                sum = sum.add(b);
            }
        }
        return sum;
    }

    public BigDecimal getBillAmount() {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : partials) {
            for (BigDecimal b : s.getBills()) {
                sum = sum.add(b);
            }
        }
        return sum;
    }

    public BigDecimal getAmount() {
        BigDecimal sum = new BigDecimal(0);
        for (StoreAccount s : partials) {
            sum = sum.add(s.getIncome());
        }
        return sum;
    }

    public int getPartialsCount() {
        return partials.size();
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store pStore) {
        store = pStore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date pDate) {
        date = pDate;
    }

    public List<StoreAccount> getPartials() {
        return partials;
    }

    public void setPartials(List<StoreAccount> pPartials) {
        partials = pPartials;
    }


}
