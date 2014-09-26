package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.enumeration.StoreType;

/**
 * Created by svenklemmer on 29.08.14.
 * <p>
 * Representing physical store
 */
@Entity
@Table(name = "store")
public class Store extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Store.class);

	@Column(name = "store_key")
	private String storeKey;

  @Column(name = "store_type")
  @Enumerated(EnumType.ORDINAL)
  private StoreType storeType;

  @OneToMany(targetEntity = Driver.class)
  @JoinTable(name="store_driver")
  @MapKeyColumn(name="driverid", unique = false, nullable = false, insertable = true, updatable = true)
  private Map<Long, Driver> driver; // http://viralpatel.net/blogs/hibernate-many-to-many-annotation-mapping-tutorial/ ?

  @OneToMany(targetEntity = Car.class)
  @JoinTable(name="store_car")
  @MapKeyColumn(name="carid", unique = false, nullable = false, insertable = true, updatable = true)
  private Map<Long, Car> car;

  @OneToMany(targetEntity = Invoice.class)
  @JoinTable(name="store_invoice")
  @MapKeyColumn(name="invoiceid", unique = false, nullable = false, insertable = true, updatable = true)
  private Map<Long, Invoice> invoice;


	public Store() { }

  public Store(String aStoreKey,
               StoreType aStoreType,
               Map<Long, Driver> aDriver,
               Map<Long, Car> aCar,
               Map<Long, Invoice> aInvoice) {
    storeKey = aStoreKey;
    storeType = aStoreType;
    driver = aDriver;
    car = aCar;
    invoice = aInvoice;
  }

  public String getStoreKey() {

    return storeKey;
  }

  public void setStoreKey(String aStoreKey) {
    storeKey = aStoreKey;
  }

  public StoreType getStoreType() {
    return storeType;
  }

  public void setStoreType(StoreType aStoreType) {
    storeType = aStoreType;
  }

  public Map<Long, Driver> getDriver() {
    return driver;
  }

  public void setDriver(Map<Long, Driver> aDriver) {
    driver = aDriver;
  }

  public Map<Long, Car> getCar() {
    return car;
  }

  public void setCar(Map<Long, Car> aCar) {
    car = aCar;
  }

  public Map<Long, Invoice> getInvoice() {
    return invoice;
  }

  public void setInvoice(Map<Long, Invoice> aInvoice) {
    invoice = aInvoice;
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

    Store store = (Store) o;

    if (car != null ? !car.equals(store.car) : store.car != null) {
      return false;
    }
    if (driver != null ? !driver.equals(store.driver) : store.driver != null) {
      return false;
    }
    if (invoice != null ? !invoice.equals(store.invoice) : store.invoice != null) {
      return false;
    }
    if (storeKey != null ? !storeKey.equals(store.storeKey) : store.storeKey != null) {
      return false;
    }
    if (storeType != store.storeType) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (storeKey != null ? storeKey.hashCode() : 0);
    result = 31 * result + (storeType != null ? storeType.hashCode() : 0);
    result = 31 * result + (driver != null ? driver.hashCode() : 0);
    result = 31 * result + (car != null ? car.hashCode() : 0);
    result = 31 * result + (invoice != null ? invoice.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Store{" +
           "storeKey='" + storeKey + '\'' +
           ", storeType=" + storeType +
           ", driver=" + driver +
           ", car=" + car +
           ", invoice=" + invoice +
           '}';
  }
}
