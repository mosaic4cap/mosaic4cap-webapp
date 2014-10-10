package de.mosaic4cap.webapp.chefui.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.mosaic4cap.webapp.Application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by svenklemmer on 10.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreControllerTest {
  private static final Logger LOGGER = Logger.getLogger(StoreControllerTest.class);

  @Autowired
  private StoreController controller;
  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void dashboardRouteIsAccessable() throws Exception {
    this.mockMvc.perform(
        get("/chefui/store/1/dashboard"))
        .andExpect(status().isOk());
  }

  @Test
  public void invoiceRouteIsAccessable() throws Exception {
    this.mockMvc.perform(
        get("/chefui/store/1/invoice"))
        .andExpect(status().isOk());
  }

  @Test
  public void employeeRouteIsAccessable() throws Exception {
    this.mockMvc.perform(
        get("/chefui/store/1/employee"))
        .andExpect(status().isOk());
  }

}
