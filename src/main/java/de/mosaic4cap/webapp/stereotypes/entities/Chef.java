package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Entity
@Table(name = "chef")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chef extends AbstractMosaic4CapEntity {
  private static final Logger LOGGER = Logger.getLogger(Chef.class);

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  /**
   * Stores this chef owns
   */
  //  @OneToMany(targetEntity = Store.class)
  //  @JoinTable(name="chef_store")
  //  @MapKeyColumn(name="storeid", unique = false, nullable = false, insertable = true, updatable = true)
  //  private Map<Long, Store> stores;

  @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Store> stores;
  // http://viralpatel.net/blogs/hibernate-one-to-many-annotation-tutorial/

  public Chef() {
  }

  public Chef(String aFirstName, String aLastName, Set<Store> aStores) {
    firstName = aFirstName;
    lastName = aLastName;
    stores = aStores;
  }

  public String getFirstName() {

    return firstName;
  }

  public void setFirstName(String aFirstName) {
    firstName = aFirstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String aLastName) {
    lastName = aLastName;
  }

  public Set<Store> getStores() {
    return stores;
  }

  public void setStores(Set<Store> aStores) {
    stores = aStores;
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

    Chef chef = (Chef) o;

    if (firstName != null ? !firstName.equals(chef.firstName) : chef.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(chef.lastName) : chef.lastName != null) {
      return false;
    }

		return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
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
