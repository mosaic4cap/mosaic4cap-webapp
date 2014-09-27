package de.mosaic4cap.webapp.restservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface StoreRepository extends CrudRepository<Store, Long> {

	public Store findByStoreKey(String storeKey);

	public Store findByStoreKeyAndChefId(String storeKey, long chefid);

	public List<Store> findAllByChefId(long chefId);
}
