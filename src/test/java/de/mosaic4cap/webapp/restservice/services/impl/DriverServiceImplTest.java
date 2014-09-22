package de.mosaic4cap.webapp.restservice.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DriverServiceImplTest extends GenericServiceTestCase {

 @Autowired
 private DriverService driverService;

 @Test
 @Override
 public void testInsert() throws Exception {
	Driver entity = new Driver("1", "", null);

	Driver returnValue = driverService.insert(entity);
	assertEquals(returnValue, entity);
 }

 @Test
 @Override
 public void testGet() throws Exception {
	Driver setupEntity = driverService.insert(new Driver("value", "", null));
	assertNotNull(setupEntity);

	assertNotNull(driverService.get(setupEntity.getId()));
 }

 @Test
 @Override
 public void testGetAll() throws Exception {
	Driver setupEntity = driverService.insert(new Driver("value", "", null));
	Driver setupEntity2 = driverService.insert(new Driver("value2", "", null));
	Driver setupEntity3 = driverService.insert(new Driver("value3", "", null));
	Driver setupEntity4 = driverService.insert(new Driver("value4", "", null));
	assertNotNull(setupEntity);
	assertNotNull(setupEntity2);
	assertNotNull(setupEntity3);
	assertNotNull(setupEntity4);

	assertNotNull(driverService.getAll());
 }

 @Test
 @Override
 public void testUpdate() throws Exception {
	Driver setupEntity = driverService.insert(new Driver("mergeEntity", "", null));
	assertNotNull(setupEntity);
	setupEntity.setFirstName("mergeUpdateEntity");

	Driver updatedEntity = driverService.update(setupEntity);
	assertEquals(updatedEntity, setupEntity);
 }

 @Test
 @Override
 public void testDeleteByObject() throws Exception {
	Driver setupEntity = driverService.insert(new Driver("removeByObjectEntity", "", null));
	assertNotNull(setupEntity);

	driverService.delete(setupEntity);
	assertNull(driverService.get(setupEntity.getId()));
 }

 @Test
 @Override
 public void testDeleteById() throws Exception {
	Driver setupEntity = driverService.insert(new Driver("removeByIdEntity", "", null));
	assertNotNull(setupEntity);

	driverService.delete(setupEntity.getId());
	assertNull(driverService.get(setupEntity.getId()));
 }
}
