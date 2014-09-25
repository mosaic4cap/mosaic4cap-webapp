package de.mosaic4cap.webapp.restservice.services;

import java.io.Serializable;
import java.util.List;

import de.mosaic4cap.webapp.restservice.dao.GenericDAO;
import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface GenericService<T extends AbstractMosaic4CapEntity, ID extends Serializable> {

	/**
	 * Persists a new Instance
	 *
	 * @param newInstance ..
	 * @return ..
	 */
	T insert(T newInstance) throws Exception;

	/**
	 * Finds an Entity by ID
	 *
	 * @param id ..
	 * @return ..
	 */
	T get(ID id) throws Exception;

	/**
	 * Retrieves all Entities of the parameterized type
	 *
	 * @return ..
	 */
	List<T> getAll() throws Exception;

	/**
	 * Reattaches a transient Entity to the persistenceContext
	 *
	 * @param transientObject ..
	 */
	T update(T transientObject) throws Exception;

	/**
	 * Removes an Entity
	 *
	 * @param persistentObject ..
	 */
	void delete(T persistentObject) throws Exception;

	/**
	 * Removes an Entity by its ID
	 *
	 * @param id ..
	 */
	void delete(ID id) throws Exception;

	public GenericDAO<T, ID> getDao();

	public void setDao(GenericDAO<T, ID> pDao);
}
