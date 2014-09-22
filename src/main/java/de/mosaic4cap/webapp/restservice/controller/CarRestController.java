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
import de.mosaic4cap.webapp.restservice.services.CarService;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class CarRestController extends AbstractRestController {
	private static final Logger LOGGER = Logger.getLogger(CarRestController.class);

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/{store}/car/{id}", method = RequestMethod.GET)
	public Car get(
			@PathVariable("store") String store,
			@PathVariable("id") long id,
			@RequestParam(required = false) String mql
	) throws Exception {
		return carService.get(id);
	}

	@RequestMapping(value = "/{store}/car", method = RequestMethod.GET)
	public List<Car> getAll(
			@PathVariable("store") String store,
			@RequestParam(required = false) String mql

	) throws Exception {
		return carService.getAll();
	}

	@RequestMapping(value = "/{store}/car/insert", method = RequestMethod.POST)
	public Car insert(
			@PathVariable("store") String store,
			Car insertObj
	) throws Exception {
		return carService.insert(insertObj);
	}

	@RequestMapping(value = "/{store}/car/update", method = RequestMethod.PUT)
	public Car update(
			@PathVariable("store") String store,
			Car updateObj
	) throws Exception {
		return carService.update(updateObj);
	}

	@RequestMapping(value = "/{store}/car/delete/{id}", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			@PathVariable("id") long objId
	) throws Exception {
		carService.delete(objId);
	}

	@RequestMapping(value = "/{store}/car/delete", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("store") String store,
			Car deleteObj
	) throws Exception {
		carService.delete(deleteObj);
	}
}
