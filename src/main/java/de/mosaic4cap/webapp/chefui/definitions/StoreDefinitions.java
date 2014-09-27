package de.mosaic4cap.webapp.chefui.definitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 24.09.2014.
 * <p>
 * ControllerAdvice to push storedata directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.controller.StoreRestController} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 *
 * TODO: replace storeService.getAll with real userinformations
 */
@ControllerAdvice
public class StoreDefinitions implements Definitions {
	private static final Logger LOGGER = Logger.getLogger(StoreDefinitions.class);

//	@Autowired
//	private StoreService storeService;

	@ModelAttribute(value = "allStores")
	public List<Store> getAllStores() throws Exception {
//		return storeService.getAll(new Long(1));
	return null;
	}
}
