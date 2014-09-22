package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.restservice.dao.StoreAccountDao;
import de.mosaic4cap.webapp.stereotypes.entities.StoreAccount;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreAccountDaoImplTest extends GenericHibernateDaoTestCase {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountDaoImplTest.class);

    @Autowired
    private StoreAccountDao storeAccountDao;

    @Test
    @Override
    public void testCreate() throws Exception {
        StoreAccount entity = new StoreAccount(new BigDecimal(1), null, null, null, null, null, new Date());

        StoreAccount returnValue = storeAccountDao.create(entity);
        assertEquals(returnValue, entity);
    }

    @Test
    @Override
    public void testRetrieve() throws Exception {
        StoreAccount setupEntity = storeAccountDao.create(new StoreAccount(new BigDecimal(2), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        assertNotNull(storeAccountDao.retrieve(setupEntity.getId()));
    }

    @Test
    @Override
    public void testRetrieveAll() throws Exception {
        StoreAccount setupEntity = storeAccountDao.create(new StoreAccount(new BigDecimal(3), null, null, null, null, null, new Date()));
        StoreAccount setupEntity2 = storeAccountDao.create(new StoreAccount(new BigDecimal(4), null, null, null, null, null, new Date()));
        StoreAccount setupEntity3 = storeAccountDao.create(new StoreAccount(new BigDecimal(5), null, null, null, null, null, new Date()));
        StoreAccount setupEntity4 = storeAccountDao.create(new StoreAccount(new BigDecimal(6), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);
        assertNotNull(setupEntity2);
        assertNotNull(setupEntity3);
        assertNotNull(setupEntity4);

        assertNotNull(storeAccountDao.retrieveAll());
    }

    @Test
    @Override
    public void testMerge() throws Exception {
        StoreAccount setupEntity = storeAccountDao.create(new StoreAccount(new BigDecimal(7), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);
        setupEntity.setIncome(new BigDecimal(12));

        StoreAccount updatedEntity = storeAccountDao.merge(setupEntity);
        assertEquals(updatedEntity, setupEntity);
    }

    @Test
    @Override
    public void testRemoveByObject() throws Exception {
        StoreAccount setupEntity = storeAccountDao.create(new StoreAccount(new BigDecimal(8), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        storeAccountDao.remove(setupEntity);
        assertNull(storeAccountDao.retrieve(setupEntity.getId()));
    }

    @Test
    @Override
    public void testRemoveById() throws Exception {
        StoreAccount setupEntity = storeAccountDao.create(new StoreAccount(new BigDecimal(9), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        storeAccountDao.remove(setupEntity.getId());
        assertNull(storeAccountDao.retrieve(setupEntity.getId()));
    }
}
