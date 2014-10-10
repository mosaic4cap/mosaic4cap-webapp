package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.chefui.controller.StoreCache;
import de.mosaic4cap.webapp.restservice.services.StoreService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 24.09.2014.
 * <p>
 * ControllerAdvice to push storedata directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.services.StoreService} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 */
@ControllerAdvice
public class StoreDefinitions implements Definitions {
	private static final Logger LOGGER = Logger.getLogger(StoreDefinitions.class);

	@Autowired
	private StoreService storeService;

	/**
	 * Passes all stores related to logged in chef to thymeleaf template engine
	 *
	 * @return
	 * @throws Exception
	 */
	@ModelAttribute(value = "allStores") //TODO: add parameter from authentication, related to issue #11
	public List<Store> getAllStores() throws Exception {
		return storeService.findAllByChefId(1);
	}

	/**
	 * passes choosen store by chef to thymeleaf
	 *
	 * @return
	 * @throws Exception
	 */
  @ModelAttribute(value = "choosenStore")
  public Store getStore() throws Exception {
    LOGGER.debug("Selected StoreId " + StoreCache.get().getStoreId());
		LOGGER.debug("Store " + storeService.get(StoreCache.get().getStoreId()));
    return storeService.findByStoreIdAndChefId(StoreCache.get().getStoreId(), 1);
  }
}
