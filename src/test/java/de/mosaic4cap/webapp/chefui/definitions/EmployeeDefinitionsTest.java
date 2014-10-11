package de.mosaic4cap.webapp.chefui.definitions;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.chefui.controller.StoreCache;
import de.mosaic4cap.webapp.restservice.services.DriverService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 10.10.14.
 */
@ContextConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDefinitionsTest {
  private static final Logger LOGGER = Logger.getLogger(EmployeeDefinitionsTest.class);

  @Autowired private EmployeeDefinitions definitions;
  @Autowired private DriverService service;

  @Test
  public void canGetAllDriverByStore() throws Exception {
    StoreCache.get().setStoreId(1);
    assertThat(definitions.getAllEmployeess().size(), is(service.findByStoreId(StoreCache.get().getStoreId()).size()));
  }
}
