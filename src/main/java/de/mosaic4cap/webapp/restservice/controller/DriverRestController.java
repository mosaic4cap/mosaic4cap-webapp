package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.chefui.helper.StoreCache;
import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by svenklemmer on 20.10.14.
 *
 * Controller accepts data from angular frontend and
 * passes it to {@link de.mosaic4cap.webapp.restservice.services.DriverService} in order to
 * process it before persisting
 */
@RestController
public class DriverRestController extends AbstractRestController {
  private static final Logger LOGGER = Logger.getLogger(DriverRestController.class);

  @Autowired
  private DriverService service;

  @RequestMapping(value = "/employee/all/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Driver> getAllEmployeess() throws Exception {
    return service.findByStoreId(StoreCache.get().getStoreId());
  }
}
