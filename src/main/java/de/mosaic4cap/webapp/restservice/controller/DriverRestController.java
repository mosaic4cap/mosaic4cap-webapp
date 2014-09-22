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
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class DriverRestController extends AbstractRestController {
	private static final Logger LOGGER = Logger.getLogger(DriverRestController.class);

	@Autowired
	private DriverService driverService;

	@RequestMapping(value = "/{store}/driver/{id}", method = RequestMethod.GET)
	public Driver get(
			@PathVariable("store") String store,
			@PathVariable("id") long id,
			@RequestParam(required = false) String mql
	) throws Exception {
		return driverService.get(id);
	}

	@RequestMapping(value = "/{store}/driver", method = RequestMethod.GET)
	public List<Driver> getAll(
			@PathVariable("store") String store,
			@RequestParam(required = false) String mql
	) throws Exception {
		return driverService.getAll();
	}

	@RequestMapping(value = "/{store}/driver/insert", method = RequestMethod.POST)
	public Driver insert(
			@PathVariable("store") String store,
			Driver insertObj
	) throws Exception {
		return driverService.insert(insertObj);
	}

	@RequestMapping(value = "/{store}/driver/update", method = RequestMethod.PUT)
	public Driver update(
			@PathVariable("store") String store,
			Driver updateObj
	) throws Exception {
		return driverService.update(updateObj);
	}

	@RequestMapping(value = "/{store}/driver/delete/{id}", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			@PathVariable("id") long objId
	) throws Exception {
		driverService.delete(objId);
	}

	@RequestMapping(value = "/{store}/driver/delete", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			Driver deleteObj
	) throws Exception {
		driverService.delete(deleteObj);
	}
}
