package de.mosaic4cap.webapp.utils;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by svenklemmer on 16.10.14.
 */
@RunWith(JUnit4.class)
public class JsonUtilTest {
  private static final Logger LOGGER = Logger.getLogger(JsonUtilTest.class);

  private String testString =  "{\"value\":\"Test\"}";

  @Test
  public void testCanDeserializeJson() throws Exception {
    TestObject testObj = JSONUtil.fromJson(testString, TestObject.class);
    assertThat(testObj, is(notNullValue()));
    assertThat(testObj.getValue(), is("Test"));
  }

  @Test
  public void testCanSerializeJson() throws Exception {
    TestObject obj = new TestObject("Test");
    String json = JSONUtil.toJson(obj);
    assertThat(json.length(), is(greaterThan(0)));
    assertThat(json, is(equalTo(testString)));
  }

  @Test
  public void testCanDeserializeJsonToList() throws Exception {
    String json = "[{\"value\":\"T1\"},{\"value\":\"T2\"},{\"value\":\"T3\"}]";

    List<TestObject> desList = JSONUtil.fromJsonToList(json, new TypeReference<List<TestObject>>() { });
    assertThat(desList.size(), is(3));
  }
}
