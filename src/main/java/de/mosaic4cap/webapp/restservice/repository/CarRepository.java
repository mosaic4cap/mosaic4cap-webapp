package de.mosaic4cap.webapp.restservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.Car;

/**
 * Created by Lobedan on 27.09.2014.
 *
 * Simple interface defining common methods used by repository implementation
 */
public interface CarRepository extends CrudRepository<Car, Long> {

	/**
	 * Finds all cars by there store
	 * @return list of all persisted cars of this store
	 */
	public List<Car> findAllByStoreId(long storeId);

	public Car findByBadge(String badge);
}
