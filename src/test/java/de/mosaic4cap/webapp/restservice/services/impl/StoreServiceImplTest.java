package de.mosaic4cap.webapp.restservice.services.impl;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.restservice.services.StoreService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 *
 * TODO: #Issue 12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreServiceImplTest extends GenericServiceTestCase {

	private static final Logger LOGGER = Logger.getLogger(StoreServiceImplTest.class);

	@Autowired
	private StoreService storeService;

	@Test
	@Override
	public void testInsert() throws Exception {
		Store entity = new Store("1", null, null, null, null);

		Store returnValue = storeService.insert(entity);
		assertEquals(returnValue, entity);
	}

	@Test
	@Override
	public void testGet() throws Exception {
		Store setupEntity = storeService.insert(new Store("2", null, null, null, null));
		assertNotNull(setupEntity);

		assertNotNull(storeService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testGetAll() throws Exception {
		Store setupEntity = storeService.insert(new Store("3", null, null, null, null));
		Store setupEntity2 = storeService.insert(new Store("4", null, null, null, null));
		Store setupEntity3 = storeService.insert(new Store("5", null, null, null, null));
		Store setupEntity4 = storeService.insert(new Store("6", null, null, null, null));
		assertNotNull(setupEntity);
		assertNotNull(setupEntity2);
		assertNotNull(setupEntity3);
		assertNotNull(setupEntity4);

		assertNotNull(storeService.getAll());
	}

	@Test
	@Override
	public void testUpdate() throws Exception {
		Store setupEntity = storeService.insert(new Store("7", null, null, null, null));
		assertNotNull(setupEntity);
		setupEntity.setKey("1234");

		Store updatedEntity = storeService.update(setupEntity);
		assertEquals(updatedEntity, setupEntity);
	}

	@Test
	@Override
	public void testDeleteByObject() throws Exception {
		Store setupEntity = storeService.insert(new Store("8", null, null, null, null));
		assertNotNull(setupEntity);

		storeService.delete(setupEntity);
		assertNull(storeService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testDeleteById() throws Exception {
		Store setupEntity = storeService.insert(new Store("9", null, null, null, null));
		assertNotNull(setupEntity);

		storeService.delete(setupEntity.getId());
		assertNull(storeService.get(setupEntity.getId()));
	}

	@Ignore
	public void testGetByChef() throws Exception {
	}

	@Ignore
	public void testGetAllByChef() throws Exception {
	}
}