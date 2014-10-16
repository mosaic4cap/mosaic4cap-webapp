package de.mosaic4cap.webapp.utils;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 16.10.14.
 */
@RunWith(JUnit4.class)
public class EnumUtilTest {
  private static final Logger LOGGER = Logger.getLogger(EnumUtilTest.class);

  private TestEnum e = TestEnum.VALUE1;

  @Test
  public void testSearchEnumByNameSuccess() throws Exception {
    TestEnum search = EnumUtil.getEnumFromString(TestEnum.class, "VALUE1");
    assertThat(search, is(e));
    assertThat(e.getDeclaringClass().getSimpleName(), is("TestEnum"));
    assertThat(search.getName(), is("This is a value"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSearchEnumByNameFailure() throws Exception {
    TestEnum search = EnumUtil.getEnumFromString(TestEnum.class, "VALUE2");
    assertThat(search, is(not(e)));
  }


  /**
   * Simple Enum for testing functionality
   */
  private enum TestEnum {
    VALUE1("This is a value");
    private String name;

    TestEnum(String pName) {
      this.name = pName;
    }

    public String getName() {
      return name;
    }
  }
}


