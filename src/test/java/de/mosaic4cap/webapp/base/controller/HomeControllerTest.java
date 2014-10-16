package de.mosaic4cap.webapp.base.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.mosaic4cap.webapp.Application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by svenklemmer on 16.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class HomeControllerTest {
  private static final Logger LOGGER = Logger.getLogger(HomeControllerTest.class);

  @Autowired
  private HomeController controller;
  private MockMvc mockMvc;

  @org.junit.Before
  public void setup() {
    this.mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void canAccessIndexPage() throws Exception {
    this.mockMvc.perform(
        get("/"))
        .andExpect(view().name("index"))
        .andExpect(status().isOk());
  }

  @Test
  public void canAccessIndexPageViaStart() throws Exception {
    this.mockMvc.perform(
        get("/start"))
        .andExpect(view().name("redirect:index"))
        .andExpect(status().isFound());
  }

  @Test
  public void canAccessIndexPageViaHome() throws Exception {
    this.mockMvc.perform(
        get("/home"))
        .andExpect(view().name("redirect:index"))
        .andExpect(status().isFound());
  }
}
