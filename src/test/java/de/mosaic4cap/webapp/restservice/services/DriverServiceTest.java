package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 10.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DriverServiceTest {
  private static final Logger LOGGER = Logger.getLogger(DriverServiceTest.class);

  @Autowired
  private DriverService service;

  @Test
  public void canGetDriverByStoreId() throws Exception {
    List<Driver> drivers = service.findByStoreId(1);
    assertThat(drivers.size(), is(3));
    assertThat(drivers.get(0).getStore().getId(), is(1L));
  }
}
