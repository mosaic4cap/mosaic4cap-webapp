package de.mosaic4cap.webapp.chefui.definitions;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.services.StoreService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lobedan on 24.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreDefinitionsTest {
	private static final Logger LOGGER = Logger.getLogger(StoreDefinitionsTest.class);

	@Autowired
	private StoreDefinitions definitions;

	@Autowired
	private StoreService service;

	@Test
	public void canGetAllStores() throws Exception {
		assertThat(definitions.getAllStores(), is(service.findAllByChefId(1)));
	}
}
