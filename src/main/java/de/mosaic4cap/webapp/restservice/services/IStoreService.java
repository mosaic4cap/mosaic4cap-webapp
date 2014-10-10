package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.core.IBaseRestService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface IStoreService extends IBaseRestService<Store, Long> {

	public Store findByStoreKey(String storeKey);

	public Store findByStoreKeyAndChefId(String storeKey, long chefid);

	public Store findByStoreIdAndChefId(long storeId, long chefid);

	public List<Store> findAllByChefId(long chefId);
}