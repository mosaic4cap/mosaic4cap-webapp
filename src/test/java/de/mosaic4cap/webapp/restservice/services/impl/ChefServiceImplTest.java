package de.mosaic4cap.webapp.restservice.services.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.ChefService;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ChefServiceImplTest extends GenericServiceTestCase {
 private static final Logger LOGGER = Logger.getLogger(ChefServiceImplTest.class);

 @Autowired
 private ChefService chefService;

 @Test
 @Override
 public void testInsert() throws Exception {
	Chef entity = new Chef("1", "", null);

	Chef returnValue = chefService.insert(entity);
	assertEquals(returnValue, entity);
 }

 @Test
 @Override
 public void testGet() throws Exception {
	Chef setupEntity = chefService.insert(new Chef("value", "", null));
	assertNotNull(setupEntity);

	assertNotNull(chefService.get(setupEntity.getId()));
 }

 @Test
 @Override
 public void testGetAll() throws Exception {
	Chef setupEntity = chefService.insert(new Chef("value", "", null));
	Chef setupEntity2 = chefService.insert(new Chef("value2", "", null));
	Chef setupEntity3 = chefService.insert(new Chef("value3", "", null));
	Chef setupEntity4 = chefService.insert(new Chef("value4", "", null));
	assertNotNull(setupEntity);
	assertNotNull(setupEntity2);
	assertNotNull(setupEntity3);
	assertNotNull(setupEntity4);

	assertNotNull(chefService.getAll());
 }

 @Test
 @Override
 public void testUpdate() throws Exception {
	Chef setupEntity = chefService.insert(new Chef("mergeEntity", "", null));
	assertNotNull(setupEntity);
	setupEntity.setFirstName("mergeUpdateEntity");

	Chef updatedEntity = chefService.update(setupEntity);
	assertEquals(updatedEntity, setupEntity);
 }

 @Test
 @Override
 public void testDeleteByObject() throws Exception {
	Chef setupEntity = chefService.insert(new Chef("removeByObjectEntity", "", null));
	assertNotNull(setupEntity);

	chefService.delete(setupEntity);
	assertNull(chefService.get(setupEntity.getId()));
 }

 @Test
 @Override
 public void testDeleteById() throws Exception {
	Chef setupEntity = chefService.insert(new Chef("removeByIdEntity", "", null));
	assertNotNull(setupEntity);

	chefService.delete(setupEntity.getId());
	assertNull(chefService.get(setupEntity.getId()));
 }
}
