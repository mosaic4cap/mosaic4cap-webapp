package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.chefui.controller.StoreCache;
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;
import de.mosaic4cap.webapp.utils.JSONUtil;

/**
 * Created by svenklemmer on 10.10.14.
 *
 * ControllerAdvice to push employee of a store directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.services.DriverService} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 */
@ControllerAdvice
public class EmployeeDefinitions implements Definitions {
  private static final Logger LOGGER = Logger.getLogger(EmployeeDefinitions.class);

  @Autowired
  private DriverService service;

  @ModelAttribute(value = "allEmployees")
  public List<Driver> getAllEmployeess() throws Exception {
    return service.findByStoreId(StoreCache.get().getStoreId());
  }

  @ModelAttribute(value = "allEmployeesJSON")
  public String getAllEmployeessJSON() throws Exception {
    return JSONUtil.toJson(service.findByStoreId(StoreCache.get().getStoreId()));
  }


}
