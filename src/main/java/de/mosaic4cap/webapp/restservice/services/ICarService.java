package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.core.IBaseRestService;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface ICarService extends IBaseRestService<Car, Long> {
	public List<Car> getAllByStoreId(long storeid);
	public Car getByBadge(String badge);
}