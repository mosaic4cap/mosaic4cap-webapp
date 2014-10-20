package de.mosaic4cap.webapp.chefui.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mosaic4cap.webapp.chefui.helper.StoreCache;
import de.mosaic4cap.webapp.core.AbstractChefUIController;

/**
 * Created by svenklemmer on 10.10.14.
 *
 * Controller for all store related views
 */
@Controller
public class StoreController extends AbstractChefUIController {
  private static final Logger LOGGER = Logger.getLogger(StoreController.class);

  @RequestMapping(value = "/store/{storeid}/", method = RequestMethod.GET)
  public String loadStoreDashboardRedirect(@PathVariable("storeid") long storeId) throws Exception {
    StoreCache.get().setStoreId(storeId);
    return "redirect:/chefui/store_dashboard";
  }

  @RequestMapping(value = "/store/{storeid}/dashboard", method = RequestMethod.GET)
  public String loadStoreDashboard(@PathVariable("storeid") long storeId) throws Exception {
    StoreCache.get().setStoreId(storeId);
    return "chefui/store_dashboard";
  }

  @RequestMapping("/store/{storeid}/invoice")
  public String invoice(@PathVariable("storeid") long storeid) {
    StoreCache.get().setStoreId(storeid);
    return "chefui/invoice";
  }

  @RequestMapping("/store/{storeid}/employee")
  public String employee(@PathVariable("storeid") long storeid) {
    StoreCache.get().setStoreId(storeid);
    return "chefui/employee";
  }
}
