package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.chefui.helper.StoreCache;
import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.StoreService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by svenklemmer on 20.10.14.
 * <p>
 * Controller for returning store details in from restservice
 * mainly used by other clients to get there data
 */
@RestController
public class StoreRestController extends AbstractRestController {
  private static final Logger LOGGER = Logger.getLogger(StoreRestController.class);

  @Autowired
  private StoreService service;

  @RequestMapping(value = "/store/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Store> getAllStores() throws Exception {
    LOGGER.debug("Accessing getAllStores() via Rest");
    return service.findAllByChefId(1);
  }

  /**
   * gets only the store, which id is stored by StoreCache *
   */
  @RequestMapping(value = "store/get/", method = RequestMethod.GET)
  public Store getStore() throws Exception {
    LOGGER.debug("Accessing getStore(storeid = " + StoreCache.get().getStoreId() + ") via Rest");
    return service.findByStoreIdAndChefId(StoreCache.get().getStoreId(), 1);
  }

  @RequestMapping(value = "store/select/", method = RequestMethod.POST)
  public long selectStore(@RequestBody long storeId) {
    if (storeId > 0) {
      StoreCache.get().setStoreId(storeId);
      return storeId;
    } else {
      return -1;
    }
  }
  @RequestMapping(value = "store/get/select/", method = RequestMethod.POST)
  public long getSelectedStore() {
    return StoreCache.get().getStoreId();
  }
}
