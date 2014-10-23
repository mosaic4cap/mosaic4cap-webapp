package de.mosaic4cap.webapp.chefui.definitions;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.chefui.helper.StoreCache;
import de.mosaic4cap.webapp.stereotypes.Configuration;

/**
 * Created by svenklemmer on 17.10.14.
 * Main definitions useable by all controller, which invokes a
 * thymleaf html view
 */
@ControllerAdvice
public class BaseDefinitions {
  private static final Logger LOGGER = Logger.getLogger(BaseDefinitions.class);

  @Autowired
  private Configuration config;

  @ModelAttribute(value = "configuration")
  public Configuration getConfiguration() {
    return config;
  }

  @ModelAttribute(value = "selectedStoreID")
  public long getSelectedStoreID() {
    return StoreCache.get().getStoreId();
  }
}
