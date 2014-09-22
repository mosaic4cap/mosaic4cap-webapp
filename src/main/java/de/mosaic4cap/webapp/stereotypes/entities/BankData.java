package de.mosaic4cap.webapp.stereotypes.entities;

import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Lobedan on 03.09.2014.
 */
@Entity
@Table(name = "bankdata")
public class BankData extends AbstractMosaicEntity {
    private static final Logger LOGGER = Logger.getLogger(BankData.class);

    private String owner;
    private String iban;
    private String bic;

    public BankData() {
    }

    public BankData(String pOwner, String pIban, String pBic) {

        owner = pOwner;
        iban = pIban;
        bic = pBic;
    }

    public String getBic() {

        return bic;
    }

    public void setBic(String pBic) {
        bic = pBic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String pIban) {
        iban = pIban;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String pOwner) {
        owner = pOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankData lBankData = (BankData) o;

        if (bic != null ? !bic.equals(lBankData.bic) : lBankData.bic != null) {
            return false;
        }
        if (iban != null ? !iban.equals(lBankData.iban) : lBankData.iban != null) {
            return false;
        }
        if (owner != null ? !owner.equals(lBankData.owner) : lBankData.owner != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int lresult = owner != null ? owner.hashCode() : 0;
        lresult = 31 * lresult + (iban != null ? iban.hashCode() : 0);
        lresult = 31 * lresult + (bic != null ? bic.hashCode() : 0);
        return lresult;
    }

    @Override
    public String toString() {
        return "BankData{" +
                "bic='" + bic + '\'' +
                ", iban='" + iban + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
