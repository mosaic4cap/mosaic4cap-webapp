package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface StoreService extends GenericService<Store, Long> {

	public Store retrieve(String key) throws Exception;

	public void remove(String key) throws Exception;

	/**
	 * Finds an entiry by ID and chef
	 *
	 * @param id
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	Store get(Long id, Long chef) throws Exception;

	/**
	 * Finds all entries by ID and chef
	 *
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	List<Store> getAll(Long chef) throws Exception;
}