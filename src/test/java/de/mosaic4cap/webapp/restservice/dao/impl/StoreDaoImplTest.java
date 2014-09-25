package de.mosaic4cap.webapp.restservice.dao.impl;

import java.util.List;

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
import de.mosaic4cap.webapp.stereotypes.entities.Store;

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

    assertThat(dao.retrieve(Long.valueOf(1), chef.getId()).getStoreKey(), is(equalTo("A01")));
    assertThat(dao.retrieve(Long.valueOf(2), chef.getId()).getStoreKey(), is(equalTo("A02")));
    assertThat(dao.retrieve(Long.valueOf(3), chef.getId()).getStoreKey(), is(equalTo("A03")));
  }

  @Test
  public void canRetrieveAllStoresByChefID() throws Exception {
    Chef chef = chefDao.retrieve(Long.valueOf(1));
    LOGGER.info(chef);
    List<Store> stores = dao.retrieveAll(chef.getId());

    assertThat(stores.size(), is(3));
  }

  @Test
  public void canRemoveStoreByKey() throws Exception {
   dao.remove("A03");
  }

  @Test
  public void canRetrieveStoreByKey() throws Exception {
    assertThat(dao.retrieve("A01").getId(), is(Long.valueOf(1)));
  }
}
