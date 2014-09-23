package de.mosaic4cap.webapp.chefui.definitions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Lobedan on 24.09.2014.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
public class StoreDefinitionsTest {
	private static final Logger LOGGER = Logger.getLogger(StoreDefinitionsTest.class);

	@Autowired
	private StoreDefinitions definitions;

	//	@Test
	public void canGetAllStores() throws Exception {
		List<Object> l = new ArrayList<>();
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		assertThat(l, is(definitions.getAllStores()));
	}
}
