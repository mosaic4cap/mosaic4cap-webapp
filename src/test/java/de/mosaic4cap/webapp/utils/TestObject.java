package de.mosaic4cap.webapp.utils;

/**
 * Created by svenklemmer on 16.10.14.
 * <p>
 * simple helper object used by {@link de.mosaic4cap.webapp.utils.JsonUtilTest}
 */
public class TestObject {
  private String value;

  public TestObject() {
  }

  public TestObject(String aValue) {
    value = aValue;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String pValue) {
    value = pValue;
  }
}
