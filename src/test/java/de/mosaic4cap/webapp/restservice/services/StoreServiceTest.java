package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 27.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreServiceTest {
	private static final Logger LOGGER = Logger.getLogger(StoreServiceTest.class);

	@Autowired
	private StoreService service;

	@Test
	public void canFindByStoreKeySuccess() throws Exception {
		Store s = service.findByStoreKey("Sample Store 1");
		assertThat(s, notNullValue());
		assertThat(s.getId(), is(1L));
		assertThat(s.getChef().getId(), is(1L));
	}

	@Test
	public void canFindByStoreKeyFailure() throws Exception {
		Store s = service.findByStoreKey("wurst");
		assertThat(s, nullValue());
	}

	@Test
	public void canFindByStoreKeyAndChefIDSuccess() throws Exception {
		Store s = service.findByStoreKeyAndChefId("Sample Store 3", 1);
		assertThat(s, notNullValue());
		assertThat(s.getId(), is(3L));
		assertThat(s.getChef().getId(), is(1L));
	}

	@Test
	public void canFindByStoreKeyAndChefIDFailureChefID() throws Exception {
		Store s = service.findByStoreKeyAndChefId("Sample Store 1", 2);
		assertThat(s, nullValue());
	}

	@Test
	public void canFindByStoreKeyAndChefIDFailureStoreKey() throws Exception {
		Store s = service.findByStoreKeyAndChefId("Sample Store 5", 1);
		assertThat(s, nullValue());
	}

	@Test
	public void canFindByStoreKeyAndChefIDFailure() throws Exception {
		Store s = service.findByStoreKeyAndChefId("hans", 2);
		assertThat(s, nullValue());
	}

	@Test
	public void canFindAllByChefIDSuccess() throws Exception {
		List<Store> storeList = service.findAllByChefId(1);
		assertThat(storeList.size(), is(3));
		storeList.forEach(s -> assertThat(s.getChef().getId(), is(1L)));
	}

	@Test
	public void canFindAllByChefIDFailure() throws Exception {
		List<Store> storeList = service.findAllByChefId(2);
		assertThat(storeList.size(), is(0));
	}
}
