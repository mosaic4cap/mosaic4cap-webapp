package de.mosaic4cap.webapp.restservice.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 27.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CarRepositoryTest {
	private static final Logger LOGGER = Logger.getLogger(CarRepositoryTest.class);

	@Autowired
	private CarRepository repository;

	@Test
	public void canFindByStoreIdSuccess() throws Exception {
		List<Car> carList = repository.findAllByStoreId(1);

		assertThat(carList, hasItem(isA(Car.class)));
		assertThat(carList.size(), is(3));

		carList.forEach(c -> assertThat(c.getStore().getId(), is(1L)));
	}

	@Test
	public void canFindByStoreIdFailure() throws Exception {
		List<Car> carList = repository.findAllByStoreId(10);
		assertThat(carList.size(), is(0));
	}

	@Test
	public void canFindByBadgeSuccess() throws Exception {
		Car data = repository.findByBadge("A-BC-001");
		assertThat(data, notNullValue());
		assertThat(data.getStore().getId(), is(1L));
		assertThat(data.getId(), is(1L));
	}

	@Test
	public void canFindByBadgeFailure() throws Exception {
		Car data = repository.findByBadge("wurst");
		assertThat(data, nullValue());
	}

//	@Test
//	public void canDeleteByBadgeSuccess() throws Exception {
//		repository.deleteByBadge("A-BC-002");
//	}
//	@Test
//	public void canDeleteByBadgeFailure() throws Exception {
//		repository.deleteByBadge("hans");
//	}
}
