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
import de.mosaic4cap.webapp.restservice.services.StoreService;
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
public class StoreRestControllerTest {
  private static final Logger LOGGER = Logger.getLogger(StoreRestControllerTest.class);

  @Autowired
  private StoreRestController controller;

  @Autowired
  private StoreService service;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void canGetAllStores() throws Exception {
    MvcResult result = this.mockMvc.perform(get("/rest/store/all"))
        .andExpect(status().isOk())
        .andReturn();

    List<Store> stores = JSONUtil.fromJsonToList(result.getResponse().getContentAsString(),
                                                 new TypeReference<List<Store>>() {
                                                 });
    assertThat(stores.size(), is(service.findAllByChefId(1).size()));
  }

  @Test
  public void canGetChoosenStore() throws Exception {
    long id = 1;
    StoreCache.get().setStoreId(id);
    Store store = service.get(1);

    MvcResult result = this.mockMvc.perform(get("/rest/store/get/"))
        .andExpect(status().isOk())
        .andReturn();
    Store s = JSONUtil.fromJson(result.getResponse().getContentAsString(), Store.class);
    assertThat(s.getStoreKey(), is(store.getStoreKey()));
  }

  @Test
  public void canSelectStore() throws Exception {
    MvcResult result = this.mockMvc.perform(get("/rest/store/select/1/"))
        .andExpect(status().isOk())
        .andReturn();
    assertThat(Long.valueOf(result.getResponse().getContentAsString()), is(StoreCache.get().getStoreId()));
  }
}
