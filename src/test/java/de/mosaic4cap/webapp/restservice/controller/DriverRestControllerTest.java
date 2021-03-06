package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.chefui.helper.StoreCache;
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;
import de.mosaic4cap.webapp.utils.JSONUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by svenklemmer on 20.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DriverRestControllerTest {
  private static final Logger LOGGER = Logger.getLogger(DriverRestControllerTest.class);

  @Autowired
  private DriverRestController controller;

  @Autowired
  private DriverService service;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void canGetAllEmployees() throws Exception {
    StoreCache.get().setStoreId(2);

    MvcResult result = this.mockMvc.perform(get("/rest/employee/all/"))
        .andExpect(status().isOk())
        .andReturn();

    List<Store> stores = JSONUtil.fromJsonToList(result.getResponse().getContentAsString(),
                                                 new TypeReference<List<Store>>() {
                                                 });
    assertThat(stores.size(), is(service.findByStoreId(StoreCache.get().getStoreId()).size()));
  }
}
