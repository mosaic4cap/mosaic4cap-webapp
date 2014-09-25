package de.mosaic4cap.webapp.restservice.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by svenklemmer on 25.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreDaoImplTest {
  private static final Logger LOGGER = Logger.getLogger(StoreDaoImplTest.class);

  @Autowired
  private StoreDao dao;

  private Store sampleStore1 = new Store("test", new Chef("test1", "test2", null), null, null, null);
  private Store sampleStore2 = new Store("test2", new Chef("test3", "test4", null), null, null, null);
  private Store sampleStore3 = new Store("test3", new Chef("test5", "test6", null), null, null, null);
  private Store sampleStore4 = new Store("test4", new Chef("test7", "test8", null), null, null, null);


  @Test
  public void canRetrieveStoreByChefID() throws Exception {

  }

  @Test
  public void canRetrieveAllStoresByChefID() throws Exception {}

  @Test
  public void canRetrieveAllStoresByKey() throws Exception {}

  @Test
  public void canRetrieveStoreByKey() throws Exception {
    List<Store> sampleStores = dao.create(sampleStore1, sampleStore2);


  }
}
