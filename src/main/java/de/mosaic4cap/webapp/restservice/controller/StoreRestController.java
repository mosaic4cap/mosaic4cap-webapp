package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.StoreService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class StoreRestController extends AbstractRestController {
	private static final Logger LOGGER = Logger.getLogger(StoreRestController.class);

	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Store get(@PathVariable("id") long id, @RequestParam(required = false) String mql
	) throws Exception {
		return storeService.get(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Store> getAll(@RequestParam(required = false) String mql) throws Exception {
		return storeService.getAll();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Store insert(Store insertObj) throws Exception {
		return storeService.insert(insertObj);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Store update(Store updateObj) throws Exception {
		return storeService.update(updateObj);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long objId) throws Exception {
		storeService.delete(objId);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(Store deleteObj) throws Exception {
		storeService.delete(deleteObj);
	}
}
