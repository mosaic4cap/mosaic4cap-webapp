package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.stereotypes.domain.Store;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreDaoImplTest extends GenericHibernateDaoTestCase {
    private static final Logger LOGGER = Logger.getLogger(StoreDaoImplTest.class);

    @Autowired
    private StoreDao storeDao;

    @Test
    @Override
    public void testCreate() throws Exception {
        Store entity = new Store("1", null, null, null, null);

        Store returnValue = storeDao.create(entity);
        assertEquals(returnValue, entity);
    }

    @Test
    @Override
    public void testRetrieve() throws Exception {
        Store setupEntity = storeDao.create(new Store("2", null, null, null, null));
        assertNotNull(setupEntity);

        assertNotNull(storeDao.retrieve(setupEntity.getId()));
    }

//    @Test
//    public void testRetrieveByKey() throws Exception {
//        Store setupEntity = storeDao.create(new Store("30", null, null, null, null));
//        assertNotNull(setupEntity);
//
//        assertNotNull(storeDao.retrieve(setupEntity.getKey()));
//    }

    @Test
    @Override
    public void testRetrieveAll() throws Exception {
        Store setupEntity = storeDao.create(new Store("3", null, null, null, null));
        Store setupEntity2 = storeDao.create(new Store("4", null, null, null, null));
        Store setupEntity3 = storeDao.create(new Store("5", null, null, null, null));
        Store setupEntity4 = storeDao.create(new Store("6", null, null, null, null));
        assertNotNull(setupEntity);
        assertNotNull(setupEntity2);
        assertNotNull(setupEntity3);
        assertNotNull(setupEntity4);

        assertNotNull(storeDao.retrieveAll());
    }

    @Test
    @Override
    public void testMerge() throws Exception {
        Store setupEntity = storeDao.create(new Store("7", null, null, null, null));
        assertNotNull(setupEntity);
        setupEntity.setKey("1234");

        Store updatedEntity = storeDao.merge(setupEntity);
        assertEquals(updatedEntity, setupEntity);
    }

    @Test
    @Override
    public void testRemoveByObject() throws Exception {
        Store setupEntity = storeDao.create(new Store("8", null, null, null, null));
        assertNotNull(setupEntity);

        storeDao.remove(setupEntity);
        assertNull(storeDao.retrieve(setupEntity.getId()));
    }

    @Test
    @Override
    public void testRemoveById() throws Exception {
        Store setupEntity = storeDao.create(new Store("9", null, null, null, null));
        assertNotNull(setupEntity);

        storeDao.remove(setupEntity.getId());
        assertNull(storeDao.retrieve(setupEntity.getId()));
    }

//    @Test
//    public void testRemoveByKey() throws Exception {
//        Store setupEntity = storeDao.create(new Store("4667", null, null, null, null));
//        assertNotNull(setupEntity);
//
//        storeDao.remove(setupEntity.getKey());
//        assertNull(storeDao.retrieve(setupEntity.getKey()));
//    }
}
