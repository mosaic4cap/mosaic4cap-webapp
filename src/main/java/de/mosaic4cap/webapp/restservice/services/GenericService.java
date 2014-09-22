package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.restservice.dao.GenericDAO;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface GenericService<T> {

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
 T get(Long id) throws Exception;

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
 void delete(Long id) throws Exception;

 public GenericDAO<T> getDao();

 public void setDao(GenericDAO<T> pDao);
}
