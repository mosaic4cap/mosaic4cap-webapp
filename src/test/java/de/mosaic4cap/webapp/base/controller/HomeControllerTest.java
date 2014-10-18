package de.mosaic4cap.webapp.base.controller;

import java.util.ArrayList;
import java.util.List;

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
    List<String> routes = new ArrayList<>();
    routes.add("/");
    routes.add("/home");
    routes.add("/start");
    routes.add("/index");

    routes.forEach(s -> {
      try {
        this.mockMvc.perform(
            get(s))
            .andExpect(view().name("index"))
            .andExpect(status().isOk());
      } catch (Exception e) {
        LOGGER.error(e);
      }
    });
  }
}
