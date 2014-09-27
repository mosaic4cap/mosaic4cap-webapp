package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.StoreRepository;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class StoreService extends BaseRestService<Store, Long> implements IStoreService {
	private static final Logger LOGGER = Logger.getLogger(StoreService.class);

	private StoreRepository repository;

	@Autowired
	public void setRepository(StoreRepository repo) {
		repository = repo; super.setRepository(repo);
	}

	@Override
	public Store findByStoreKey(String storeKey) {
		return repository.findByStoreKey(storeKey);
	}

	@Override
	public Store findByStoreKeyAndChefId(String storeKey, long chefid) {
		return repository.findByStoreKeyAndChefId(storeKey, chefid);
	}

	@Override
	public List<Store> findAllByChefId(long chefId) {
		return repository.findAllByChefId(chefId);
	}
}
