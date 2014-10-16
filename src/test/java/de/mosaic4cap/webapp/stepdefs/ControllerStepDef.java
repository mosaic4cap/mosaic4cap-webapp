package de.mosaic4cap.webapp.stepdefs;

import org.apache.log4j.Logger;
import org.springframework.test.web.servlet.MockMvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.mosaic4cap.webapp.base.controller.HomeController;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by svenklemmer on 16.10.14.
 *
 * Stepdefs usable by all controller cucumber bdd tests
 */
public class ControllerStepDef {
  private static final Logger LOGGER = Logger.getLogger(ControllerStepDef.class);

  private MockMvc mockMvc;
  private String route;

  @Given("initialized $w")
  public void initializeController(String controllerValue) throws Exception {
    switch (controllerValue) {
      case "HomeController":
        mockMvc = standaloneSetup(new HomeController()).build();
        break;
      default:
        mockMvc = standaloneSetup(new HomeController()).build();
        break;
    }
  }

  @When("user enters $w")
  public void userEnter(String value) {
    route = value;
  }

  @Then("template with name $w will be displayed")
  public void execute(String tpl) throws Exception {
    assertThat(mockMvc, notNullValue());

    this.mockMvc.perform(
        get(route))
        .andExpect(status().isOk())
        .andExpect(view().name(tpl));
  }
}
