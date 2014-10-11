package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.DriverRepository;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class DriverService extends BaseRestService<Driver, Long> implements IDriverService {
	private static final Logger LOGGER = Logger.getLogger(DriverService.class);

	private DriverRepository repo;

	@Autowired
	public void setRepository(DriverRepository aRepo) {
		repo = aRepo; super.setRepository(aRepo);
	}

	@Override
	public List<Driver> findByStoreId(long storeId) {
		return repo.findByStoreId(storeId);
	}
}
