package de.mosaic4cap.webapp.restservice.dao;

import java.util.List;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface StoreDao extends GenericDAO<Store, Long> {

  /**
   * Gets a Store by its identifier key
   *
   * @param key
   * @return
   * @throws Exception
   */
	Store retrieve(String key) throws Exception;

  /**
   * removes a store found by its identifier key
   * @param key
   * @throws Exception
   */
	void remove(String key) throws Exception;

	/**
	 * Gets Store by its chef
	 *
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	Store retrieve(Long id, Long chef) throws Exception;

	/**
	 * Gets all Stores by its chef
	 *
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	List<Store> retrieveAll(Long chef) throws Exception;
}
