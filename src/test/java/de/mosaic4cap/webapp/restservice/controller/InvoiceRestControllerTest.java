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
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
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
public class InvoiceRestControllerTest {
  private static final Logger LOGGER = Logger.getLogger(InvoiceRestControllerTest.class);

  @Autowired
  private InvoiceRestController controller;

  @Autowired
  private InvoiceService service;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void canGetAllInvoicesInAContainer() throws Exception {
    StoreCache.get().setStoreId(1);
    List<InvoiceContainer> invoiceContainers = service.getGroupedInvoices(StoreCache.get().getStoreId());

    MvcResult result = this.mockMvc.perform(get("/rest/invoice/all"))
        .andExpect(status().isOk())
        .andReturn();

    List<InvoiceContainer> s = JSONUtil.fromJsonToList(result.getResponse().getContentAsString(),
                                                 new TypeReference<List<InvoiceContainer>>() {
                                                 });
    assertThat(s.size(), is(invoiceContainers.size()));
  }

  @Test
  public void canSaveInvoiceContainer() throws Exception {
    assertThat(true, is(true));
    //TODO: implement
  }
}
