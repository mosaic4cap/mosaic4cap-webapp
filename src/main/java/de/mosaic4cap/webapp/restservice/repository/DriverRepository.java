package de.mosaic4cap.webapp.restservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface DriverRepository extends CrudRepository<Driver, Long> {
  public List<Driver> findByStoreId(long storeId);
}
