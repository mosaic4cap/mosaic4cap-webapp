package de.mosaic4cap.webapp.restservice.dao;

import java.util.List;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface StoreDao extends GenericDAO<Store> {

	public Store retrieve(String key) throws Exception;

	public void remove(String key) throws Exception;

	/**
	 * Gets Store by its chef
	 *
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	public Store retrieve(Long id, Long chef) throws Exception;

	/**
	 * Gets all Stores by its chef
	 *
	 * @param chef
	 * @return
	 * @throws Exception
	 */
	public List<Store> retrieveAll(Long chef) throws Exception;
}
