package de.mosaic4cap.webapp.chefui.definitions;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.stereotypes.enumeration.Enviroment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by svenklemmer on 18.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class BaseDefinitionsTest {
  private static final Logger LOGGER = Logger.getLogger(BaseDefinitionsTest.class);

  @Autowired
  private BaseDefinitions definitions;

  @Test
  public void testCanGetConfiguration() throws Exception {
    assertThat(definitions.getConfiguration().getEnviroment(), is(Enviroment.LOCAL));

    definitions.getConfiguration().setEnviroment(Enviroment.PRODUCTION);
    assertThat(definitions.getConfiguration().getEnviroment(), is(Enviroment.PRODUCTION));
  }
}
