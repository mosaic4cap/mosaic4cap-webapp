package de.mosaic4cap.webapp.restservice.repository;

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
 * Created by svenklemmer on 11.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DriverRepositoryTest {
  private static final Logger LOGGER = Logger.getLogger(DriverRepositoryTest.class);

  @Autowired
  private DriverRepository repo;

  @Test
  public void canGetByStoreId() throws Exception {
    List<Driver> driverList = repo.findByStoreId(2);
    assertThat(driverList.size(), is(3));
    assertThat(driverList.get(0).getStore().getId(), is(2L));
  }
}
