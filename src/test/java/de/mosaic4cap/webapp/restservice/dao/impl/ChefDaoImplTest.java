package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.restservice.dao.GenericHibernateDaoTestCase;
import de.mosaic4cap.webapp.stereotypes.domain.Chef;
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
public class ChefDaoImplTest extends GenericHibernateDaoTestCase {
    private static final Logger LOGGER = Logger.getLogger(ChefDaoImplTest.class);

    @Autowired
    private ChefDao chefDao;

    @Test
    @Override
    public void testCreate() throws Exception {
        Chef entity = new Chef("1", "2", null);

        Chef returnValue = chefDao.create(entity);
        assertEquals(returnValue, entity);
    }

    @Test
    @Override
    public void testRetrieve() throws Exception {
        Chef setupEntity = chefDao.create(new Chef("value", "value", null));
        assertNotNull(setupEntity);

        assertNotNull(chefDao.retrieve(setupEntity.getId()));
    }

    @Test
    @Override
    public void testRetrieveAll() throws Exception {
        Chef setupEntity = chefDao.create(new Chef("value", "", null));
        Chef setupEntity2 = chefDao.create(new Chef("value2", "", null));
        Chef setupEntity3 = chefDao.create(new Chef("value3", "", null));
        Chef setupEntity4 = chefDao.create(new Chef("value4", "", null));
        assertNotNull(setupEntity);
        assertNotNull(setupEntity2);
        assertNotNull(setupEntity3);
        assertNotNull(setupEntity4);

        assertNotNull(chefDao.retrieveAll());
    }

    @Test
    @Override
    public void testMerge() throws Exception {
        Chef setupEntity = chefDao.create(new Chef("mergeEntity", "", null));
        assertNotNull(setupEntity);

        setupEntity.setLastName("mergeUpdateEntity");
        Chef updatedEntity = chefDao.merge(setupEntity);
        assertEquals(updatedEntity, setupEntity);
    }

    @Test
    @Override
    public void testRemoveByObject() throws Exception {
        Chef setupEntity = chefDao.create(new Chef("removeByObjectEntity", "", null));
        assertNotNull(setupEntity);

        chefDao.remove(setupEntity);
        assertNull(chefDao.retrieve(setupEntity.getId()));
    }

    @Test
    @Override
    public void testRemoveById() throws Exception {
        Chef setupEntity = chefDao.create(new Chef("removeByIdEntity", "", null));
        assertNotNull(setupEntity);

        chefDao.remove(setupEntity.getId());
        assertNull(chefDao.retrieve(setupEntity.getId()));
    }
}
