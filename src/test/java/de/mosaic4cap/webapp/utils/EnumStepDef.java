package de.mosaic4cap.webapp.utils;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lobedan on 09.09.2014.
 */
public class EnumStepDef {
 private static Logger logger = Logger.getLogger(EnumStepDef.class);

 //CHECKSTYLE:OFF
 @Rule
 public ExpectedException exception = ExpectedException.none();
 //CHECKSTYLE:ON
 private TestEnum e;

 @Given("^there is an enum")
 public void initTestenum() {
	e = TestEnum.VALUE1;
 }

 @When("^i search for Class type of \"([^\"]*)\"$")
 public void searchEnumByName(String value) {
	e = EnumUtil.getEnumFromString(TestEnum.class, value);
 }

 @Then("^i should receive \"([^\"]*)\" type$")
 public void checkForType(String type) {
	assertTrue(e.getDeclaringClass().getSimpleName().equals(type));
 }

 @Then("i should get an IllegalArgumentException")
 public void checkForException() {
 }

 @And("^it should print \"([^\"]*)\"$")
 public void checkValue(String value) {
	assertEquals(e.getName(), value);
 }

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
