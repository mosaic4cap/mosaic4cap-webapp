package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.core.IBaseRestService;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface IDriverService extends IBaseRestService<Driver, Long> {
  public List<Driver> findByStoreId(long storeId);
}
