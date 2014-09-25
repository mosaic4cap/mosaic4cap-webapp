package de.mosaic4cap.webapp.helper;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by svenklemmer on 25.09.14.
 */
@Entity
@Table(name = "junit_person")
public class Person extends AbstractMosaic4CapEntity {
  private static final Logger LOGGER = Logger.getLogger(Person.class);

  private String value;

  public Person() { }

  public Person(String aValue) {
    value = aValue;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String aValue) {
    value = aValue;
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

    Person person = (Person) o;
    if (value != null ? !value.equals(person.value) : person.value != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Person{" +
           "value='" + value + '\'' +
           '}';
  }
}
