package de.mosaic4cap.webapp.stereotypes.domain;

import org.apache.log4j.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Entity
@Table(name = "chef")
public class Chef extends AbstractMosaicEntity {
    private static final Logger LOGGER = Logger.getLogger(Chef.class);

    @Column(name = "firstname", length = 25)
    private String firstName;

    @Column(name = "lastname", length = 25)
    private String lastName;

    /**
     * Stores this chef owns
     */
    @OneToMany(mappedBy = "key", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Store> stores;

    public Chef() {
    }

    public Chef(String pFirstName, String pLastName, List<Store> pStores) {
        firstName = pFirstName;
        lastName = pLastName;
        stores = pStores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> pStores) {
        stores = pStores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Chef lChef = (Chef) o;

        if (firstName != null ? !firstName.equals(lChef.firstName) : lChef.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(lChef.lastName) : lChef.lastName != null) {
            return false;
        }
        if (stores != null ? !stores.equals(lChef.stores) : lChef.stores != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int lresult = super.hashCode();
        lresult = 31 * lresult + (firstName != null ? firstName.hashCode() : 0);
        lresult = 31 * lresult + (lastName != null ? lastName.hashCode() : 0);
        lresult = 31 * lresult + (stores != null ? stores.hashCode() : 0);
        return lresult;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", stores=" + stores +
                '}';
    }
}
