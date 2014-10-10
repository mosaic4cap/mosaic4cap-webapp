package de.mosaic4cap.webapp.restservice.repository;

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
public class StoreRepositoryTest {
	private static final Logger LOGGER = Logger.getLogger(StoreRepositoryTest.class);

	@Autowired
	private StoreRepository repository;

	@Test
	public void canFindStoresByKeySuccess() throws Exception {
		Store store = repository.findByStoreKey("Sample Store 1");
		assertThat(store, notNullValue());
		assertThat(store.getChef().getId(), is(1L));

		store = repository.findByStoreKey("Sample Store 2");
		assertThat(store, notNullValue());
		assertThat(store.getChef().getId(), is(1L));

		store = repository.findByStoreKey("Sample Store 3");
		assertThat(store, notNullValue());
		assertThat(store.getChef().getId(), is(1L));
	}

	@Test
	public void canFindStoresByKeyFailure() throws Exception {
		Store store = repository.findByStoreKey("ass");
		assertThat(store, nullValue());
	}

	@Test
	public void canFindStoreByKeyAndChefSuccess() throws Exception {
		Store store = repository.findByStoreKeyAndChefId("Sample Store 1", 1);
		assertThat(store, notNullValue());

		store = repository.findByStoreKeyAndChefId("Sample Store 3", 1);
		assertThat(store, notNullValue());
	}

	@Test
	public void canFindStoreByKeyAndChefFailureWrongChef() throws Exception {
		Store store = repository.findByStoreKeyAndChefId("Sample Store 1", 3);
		assertThat(store, nullValue());
	}

	@Test
	public void canFindStoreByKeyAndChefFailureWrongKey() throws Exception {
		Store store = repository.findByStoreKeyAndChefId("arsch", 1);
		assertThat(store, nullValue());
	}

	@Test
	public void canFindStoreByKeyAndChefFailure() throws Exception {
		Store store = repository.findByStoreKeyAndChefId("depp", 2);
		assertThat(store, nullValue());
	}

	@Test
	public void canFindAllStoresByChefIdSuccess() throws Exception {
		List<Store> storeList = repository.findAllByChefId(1);
		assertThat(storeList, notNullValue());
		assertThat(storeList.size(), is(3));
	}

	@Test
	public void canFindAllStoresByChefIdFailure() throws Exception {
		List<Store> storeList = repository.findAllByChefId(2);
		assertThat(storeList.size(), is(0));
	}

	@Test
	public void canFindStoreByIdAndChefSuccess() throws Exception {
		Store store = repository.findByIdAndChefId(1, 1);
		assertThat(store, notNullValue());

		store = repository.findByIdAndChefId(2, 1);
		assertThat(store, notNullValue());
	}

	@Test
	public void canFindStoreByIdAndChefFailureWrongChef() throws Exception {
		Store store = repository.findByIdAndChefId(1, 3);
		assertThat(store, nullValue());
	}

	@Test
	public void canFindStoreByIdAndChefFailureWrongId() throws Exception {
		Store store = repository.findByIdAndChefId(1001, 1);
		assertThat(store, nullValue());
	}

//
//	@Test
//	public void canDeleteStoreByKeySuccess() throws Exception {
//		repository.deleteByStoreKey("Sample Store 1");
//	}
//
//	@Test
//	public void canDeleteStoreByKeyFailure() throws Exception {
//		repository.deleteByStoreKey("Wurst");
//	}
}

