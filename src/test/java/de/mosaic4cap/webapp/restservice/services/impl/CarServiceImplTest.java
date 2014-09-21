package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.domain.Car;
import de.mosaic4cap.webapp.restservice.services.CarService;
import de.mosaic4cap.webapp.restservice.services.GenericServiceTestCase;
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
public class CarServiceImplTest extends GenericServiceTestCase {
    private static final Logger LOGGER = Logger.getLogger(CarServiceImplTest.class);

    @Autowired
    private CarService carService;

    @Test
    @Override
    public void testInsert() throws Exception {
        Car entity = new Car("1", true);

        Car returnValue = carService.insert(entity);
        assertEquals(returnValue, entity);
    }

    @Test
    @Override
    public void testGet() throws Exception {
        Car setupEntity = carService.insert(new Car("value", false));
        assertNotNull(setupEntity);

        assertNotNull(carService.get(setupEntity.getId()));
    }

    @Test
    @Override
    public void testGetAll() throws Exception {
        Car setupEntity = carService.insert(new Car("value", false));
        Car setupEntity2 = carService.insert(new Car("value2", false));
        Car setupEntity3 = carService.insert(new Car("value3", false));
        Car setupEntity4 = carService.insert(new Car("value4", false));
        assertNotNull(setupEntity);
        assertNotNull(setupEntity2);
        assertNotNull(setupEntity3);
        assertNotNull(setupEntity4);

        assertNotNull(carService.getAll());
    }

    @Test
    @Override
    public void testUpdate() throws Exception {
        Car setupEntity = carService.insert(new Car("mergeEntity", false));
        assertNotNull(setupEntity);

        setupEntity.setBadge("mergeUpdateEntity");
        Car updatedEntity = carService.update(setupEntity);
        assertEquals(updatedEntity, setupEntity);
    }

    @Test
    @Override
    public void testDeleteByObject() throws Exception {
        Car setupEntity = carService.insert(new Car("removeByObjectEntity", false));
        assertNotNull(setupEntity);

        carService.delete(setupEntity);
        assertNull(carService.get(setupEntity.getId()));
    }

    @Test
    @Override
    public void testDeleteById() throws Exception {
        Car setupEntity = carService.insert(new Car("removeByIdEntity", false));
        assertNotNull(setupEntity);

        carService.delete(setupEntity.getId());
        assertNull(carService.get(setupEntity.getId()));
    }
}
