package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.CarRepository;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class CarService extends BaseRestService<Car, Long> implements ICarService {
	private static final Logger LOGGER = Logger.getLogger(CarService.class);

	private CarRepository repository;

	@Autowired
	public void setRepository(CarRepository repo) {
		this.repository = repo; super.setRepository(repo);
	}

	@Override
	public List<Car> getAllByStoreId(long storeid) {
		return repository.findAllByStoreId(storeid);
	}

	@Override
	public Car getByBadge(String badge) {
		return repository.findByBadge(badge);
	}
}
