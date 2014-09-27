package de.mosaic4cap.webapp.restservice.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.ChefRepository;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class ChefService extends BaseRestService<Chef, Long> implements IChefService {
	private static final Logger LOGGER = Logger.getLogger(ChefService.class);

	@Autowired
	public void setRepository(ChefRepository repo) {
		super.setRepository(repo);
	}
}
