package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
import de.mosaic4cap.webapp.restservice.services.StoreAccountService;
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
public class StoreAccountServiceImplTest extends GenericServiceTestCase {

    private static final Logger LOGGER = Logger.getLogger(StoreAccountServiceImplTest.class);

    @Autowired
    private StoreAccountService storeAccountService;

    @Test
    @Override
    public void testInsert() throws Exception {
        StoreAccount entity = new StoreAccount(new BigDecimal(1), null, null, null, null, null, new Date());

        StoreAccount returnValue = storeAccountService.insert(entity);
        assertEquals(returnValue, entity);
    }

    @Test
    @Override
    public void testGet() throws Exception {
        StoreAccount setupEntity = storeAccountService.insert(new StoreAccount(new BigDecimal(2), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        assertNotNull(storeAccountService.get(setupEntity.getId()));
    }

    @Test
    @Override
    public void testGetAll() throws Exception {
        StoreAccount setupEntity = storeAccountService.insert(new StoreAccount(new BigDecimal(3), null, null, null, null, null, new Date()));
        StoreAccount setupEntity2 = storeAccountService.insert(new StoreAccount(new BigDecimal(4), null, null, null, null, null, new Date()));
        StoreAccount setupEntity3 = storeAccountService.insert(new StoreAccount(new BigDecimal(5), null, null, null, null, null, new Date()));
        StoreAccount setupEntity4 = storeAccountService.insert(new StoreAccount(new BigDecimal(6), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);
        assertNotNull(setupEntity2);
        assertNotNull(setupEntity3);
        assertNotNull(setupEntity4);

        assertNotNull(storeAccountService.getAll());
    }

    @Test
    @Override
    public void testUpdate() throws Exception {
        StoreAccount setupEntity = storeAccountService.insert(new StoreAccount(new BigDecimal(7), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);
        setupEntity.setIncome(new BigDecimal(1234));

        StoreAccount updatedEntity = storeAccountService.update(setupEntity);
        assertEquals(updatedEntity, setupEntity);
    }

    @Test
    @Override
    public void testDeleteByObject() throws Exception {
        StoreAccount setupEntity = storeAccountService.insert(new StoreAccount(new BigDecimal(8), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        storeAccountService.delete(setupEntity);
        assertNull(storeAccountService.get(setupEntity.getId()));
    }

    @Test
    @Override
    public void testDeleteById() throws Exception {
        StoreAccount setupEntity = storeAccountService.insert(new StoreAccount(new BigDecimal(9), null, null, null, null, null, new Date()));
        assertNotNull(setupEntity);

        storeAccountService.delete(setupEntity.getId());
        assertNull(storeAccountService.get(setupEntity.getId()));
    }
}

