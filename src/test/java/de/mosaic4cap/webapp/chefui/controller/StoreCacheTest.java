package de.mosaic4cap.webapp.chefui.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.repository.StoreRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreCacheTest {

  @Autowired
  private StoreRepository repo;

  @Test
  public void firstStoreIdDoesntExist() throws Exception {
    assertThat(repo.exists(StoreCache.get().getStoreId()), is(false));
  }

  @Test
  public void canHoldAStoreID() throws Exception {
    StoreCache.get().setStoreId(1220);
    assertThat(StoreCache.get().getStoreId(), is(1220L));
  }
}