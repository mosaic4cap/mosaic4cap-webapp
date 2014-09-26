package de.mosaic4cap.webapp.restservice.services.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.CarService;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CarServiceImplTest extends GenericServiceTestCase {
	private static final Logger LOGGER = Logger.getLogger(CarServiceImplTest.class);

	@Autowired
	private CarService carService;

	@Test
	@Override
	public void testInsert() throws Exception {
		Car entity = new Car("1", true, null);

		Car returnValue = carService.insert(entity);
		assertEquals(returnValue, entity);
	}

	@Test
	@Override
	public void testGet() throws Exception {
		Car setupEntity = carService.insert(new Car("value", false, null));
		assertNotNull(setupEntity);

		assertNotNull(carService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testGetAll() throws Exception {
		Car setupEntity = carService.insert(new Car("value", false, null));
		Car setupEntity2 = carService.insert(new Car("value2", false, null));
		Car setupEntity3 = carService.insert(new Car("value3", false, null));
		Car setupEntity4 = carService.insert(new Car("value4", false, null));
		assertNotNull(setupEntity);
		assertNotNull(setupEntity2);
		assertNotNull(setupEntity3);
		assertNotNull(setupEntity4);

		assertNotNull(carService.getAll());
	}

	@Test
	@Override
	public void testUpdate() throws Exception {
		Car setupEntity = carService.insert(new Car("mergeEntity", false, null));
		assertNotNull(setupEntity);

		setupEntity.setBadge("mergeUpdateEntity");
		Car updatedEntity = carService.update(setupEntity);
		assertEquals(updatedEntity, setupEntity);
	}

	@Test
	@Override
	public void testDeleteByObject() throws Exception {
		Car setupEntity = carService.insert(new Car("removeByObjectEntity", false, null));
		assertNotNull(setupEntity);

		carService.delete(setupEntity);
		assertNull(carService.get(setupEntity.getId()));
	}

	@Test
	@Override
	public void testDeleteById() throws Exception {
		Car setupEntity = carService.insert(new Car("removeByIdEntity", false, null));
		assertNotNull(setupEntity);

		carService.delete(setupEntity.getId());
		assertNull(carService.get(setupEntity.getId()));
	}
}
