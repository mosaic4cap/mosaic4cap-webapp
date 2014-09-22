package de.mosaic4cap.webapp.restservice.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.DriverDao;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DriverDaoImplTest extends GenericHibernateDaoTestCase {
 private static final Logger LOGGER = Logger.getLogger(DriverDaoImplTest.class);

 @Autowired
 private DriverDao driverDao;

 @Test
 @Override
 public void testCreate() throws Exception {
	Driver entity = new Driver("1", "2", new Date());

	Driver returnValue = driverDao.create(entity);
	assertEquals(returnValue, entity);
 }

 @Test
 @Override
 public void testRetrieve() throws Exception {
	Driver setupEntity = driverDao.create(new Driver("value", "value", new Date()));
	assertNotNull(setupEntity);

	assertNotNull(driverDao.retrieve(setupEntity.getId()));
 }

 @Test
 @Override
 public void testRetrieveAll() throws Exception {
	Driver setupEntity = driverDao.create(new Driver("value", "", new Date()));
	Driver setupEntity2 = driverDao.create(new Driver("value2", "", new Date()));
	Driver setupEntity3 = driverDao.create(new Driver("value3", "", new Date()));
	Driver setupEntity4 = driverDao.create(new Driver("value4", "", new Date()));
	assertNotNull(setupEntity);
	assertNotNull(setupEntity2);
	assertNotNull(setupEntity3);
	assertNotNull(setupEntity4);

	assertNotNull(driverDao.retrieveAll());
 }

 @Test
 @Override
 public void testMerge() throws Exception {
	Driver setupEntity = driverDao.create(new Driver("mergeEntity", "", new Date()));
	assertNotNull(setupEntity);

	setupEntity.setLastName("mergeUpdateEntity");
	Driver updatedEntity = driverDao.merge(setupEntity);
	assertEquals(updatedEntity, setupEntity);
 }

 @Test
 @Override
 public void testRemoveByObject() throws Exception {
	Driver setupEntity = driverDao.create(new Driver("removeByObjectEntity", "", new Date()));
	assertNotNull(setupEntity);

	driverDao.remove(setupEntity);
	assertNull(driverDao.retrieve(setupEntity.getId()));
 }

 @Test
 @Override
 public void testRemoveById() throws Exception {
	Driver setupEntity = driverDao.create(new Driver("removeByIdEntity", "", new Date()));
	assertNotNull(setupEntity);

	driverDao.remove(setupEntity.getId());
	assertNull(driverDao.retrieve(setupEntity.getId()));
 }
}
