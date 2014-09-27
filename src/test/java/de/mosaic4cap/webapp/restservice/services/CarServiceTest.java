package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 27.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CarServiceTest {
	private static final Logger LOGGER = Logger.getLogger(CarServiceTest.class);

	@Autowired
	private CarService service;

	@Test
	public void canGetAllByStoreIdSuccess() throws Exception {
		List<Car> carList = service.getAllByStoreId(1);
		assertThat(carList.size(), is(3));

		carList.clear();
		carList = service.getAllByStoreId(3);
		assertThat(carList.size(), is(3));
	}

	@Test
	public void canGetAllByStoreIdFailure() throws Exception {
		List<Car> carList = service.getAllByStoreId(5);
		assertThat(carList.size(), is(0));
	}

	@Test
	public void canGetByBadgeSuccess() throws Exception {
		Car c = service.getByBadge("A-BC-007");
		assertThat(c.getId(), is(7L));
	}

	@Test
	public void canGetByBadgeFailure() throws Exception {
		Car c = service.getByBadge("wurst");
		assertThat(c, nullValue());
	}
}
