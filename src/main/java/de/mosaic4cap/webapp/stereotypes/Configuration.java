package de.mosaic4cap.webapp.stereotypes;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import de.mosaic4cap.webapp.stereotypes.enumeration.Enviroment;

/**
 * Created by svenklemmer on 17.10.14.
 *
 * Base configuration which values are defined in a
 * application.properties, which is used by spring boot and thymeleaf
 * themselfs
 */
@Component
public class Configuration {
  private static final Logger LOGGER = Logger.getLogger(Configuration.class);

  private Enviroment enviroment = Enviroment.LOCAL;

  public Configuration() { }

  public Configuration(Enviroment aEnviroment) {
    enviroment = aEnviroment;
  }

  public Enviroment getEnviroment() {
    return enviroment;
  }

  public void setEnviroment(Enviroment aEnviroment) {
    enviroment = aEnviroment;
  }

  @Override
  public String toString() {
    return "Configuration{" +
           "enviroment=" + enviroment +
           '}';
  }
}
