package de.mosaic4cap.webapp.restservice.dao.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.CarDao;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CarDaoImplTest extends GenericHibernateDaoTestCase {
	private static final Logger LOGGER = Logger.getLogger(CarDaoImplTest.class);

	@Autowired
	private CarDao carDao;

	@Test
	@Override
	public void testCreate() throws Exception {
		Car entity = new Car("1", true);

		Car returnValue = carDao.create(entity);
		assertEquals(returnValue, entity);
	}

	@Test
	@Override
	public void testRetrieve() throws Exception {
		Car setupEntity = carDao.create(new Car("value", false));
		assertNotNull(setupEntity);

		assertNotNull(carDao.retrieve(setupEntity.getId()));
	}

	@Test
	@Override
	public void testRetrieveAll() throws Exception {
		Car setupEntity = carDao.create(new Car("value", false));
		Car setupEntity2 = carDao.create(new Car("value2", false));
		Car setupEntity3 = carDao.create(new Car("value3", false));
		Car setupEntity4 = carDao.create(new Car("value4", false));
		assertNotNull(setupEntity);
		assertNotNull(setupEntity2);
		assertNotNull(setupEntity3);
		assertNotNull(setupEntity4);

		assertNotNull(carDao.retrieveAll());
	}

	@Test
	@Override
	public void testMerge() throws Exception {
		Car setupEntity = carDao.create(new Car("mergeEntity", false));
		assertNotNull(setupEntity);

		setupEntity.setBadge("mergeUpdateEntity");
		Car updatedEntity = carDao.merge(setupEntity);
		assertEquals(updatedEntity, setupEntity);
	}

	@Test
	@Override
	public void testRemoveByObject() throws Exception {
		Car setupEntity = carDao.create(new Car("removeByObjectEntity", false));
		assertNotNull(setupEntity);

		carDao.remove(setupEntity);
		assertNull(carDao.retrieve(setupEntity.getId()));
	}

	@Test
	@Override
	public void testRemoveById() throws Exception {
		Car setupEntity = carDao.create(new Car("removeByIdEntity", false));
		assertNotNull(setupEntity);

		carDao.remove(setupEntity.getId());
		assertNull(carDao.retrieve(setupEntity.getId()));
	}
}
