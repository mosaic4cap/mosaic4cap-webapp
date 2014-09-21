package de.mosaic4cap.webapp.utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.mosaic4cap.webapp.utils.helper.TestObject;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lobedan on 09.09.2014.
 */
public class JsonStepdef {
    private static Logger logger = Logger.getLogger(JsonStepdef.class);

    private TestObject t;
    private String st;
    private Object obj;

    @Given("there is a TestObject")
    public void initTestObject() {
        t = new TestObject("Test");
    }


    @Given("^there is a String")
    public void initTestString() {
        st = "{\"value\":\"Test\"}";
    }
    @When("i convert it to json")
    public void convertToJson() throws Exception {
        st = JSONUtil.toJSON(t);
        obj = JSONUtil.toJSON(t);
    }

    @When("i convert it to object")
    public void convertToObject() throws Exception {
        obj = JSONUtil.fromJSON(st, TestObject.class);
    }

    @Then("its of type string")
    public void instanceOfString() {
        assertTrue(obj instanceof String);
    }

    @Then("its of type TestObject")
    public void instanceOfTestobj() {
        assertTrue(obj instanceof TestObject);
        t = (TestObject) obj;
    }

    @And("^i can read its value \"([^\"]*)\"$")
    public void testValue(String value) {
        assertEquals(t.getValue(), value);
    }

    @And("its not empty")
    public void notEmpty() {
        assertFalse(st.isEmpty());
    }
}
