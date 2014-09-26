package de.mosaic4cap.webapp.restservice.dao.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by svenklemmer on 25.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreDaoImplTest {
  private static final Logger LOGGER = Logger.getLogger(StoreDaoImplTest.class);

  @Autowired
  private StoreDao dao;

  @Autowired
  private ChefDao chefDao;

  @Test
  public void canRetrieveStoreByChefID() throws Exception {
    Chef chef = chefDao.retrieve(Long.valueOf(1));

    assertThat(dao.retrieve(Long.valueOf(1), chef.getId()).getStoreKey(), is(equalTo("Sample Store 1")));
    assertThat(dao.retrieve(Long.valueOf(2), chef.getId()).getStoreKey(), is(equalTo("Sample Store 2")));
    assertThat(dao.retrieve(Long.valueOf(3), chef.getId()).getStoreKey(), is(equalTo("Sample Store 3")));
  }

  @Test
  public void canRetrieveAllStoresByChefID() throws Exception {
    Chef chef = chefDao.retrieve(Long.valueOf(1));
    LOGGER.info(chef);

    assertThat(chef.getStores().size(), is(3));
  }

  @Test
  public void canRemoveStoreByKey() throws Exception {
   dao.remove("Sample Store 3");
  }

  @Test
  public void canRetrieveStoreByKey() throws Exception {
		LOGGER.info(dao.retrieveAll());

    assertThat(dao.retrieve("Sample Store 1").getId(), is(Long.valueOf(1)));
  }
}
