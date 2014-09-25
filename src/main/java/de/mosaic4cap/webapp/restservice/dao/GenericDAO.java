package de.mosaic4cap.webapp.restservice.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by svenklemmer on 29.08.14.
 * Basic CRUD operations. Based on pattern "genericDAO".
 */
@SuppressWarnings("unchecked")
public interface GenericDAO<T extends AbstractMosaic4CapEntity, ID extends Serializable> {

	/**
	 * Persists a new Instance
	 *
	 * @param newInstance ..
	 * @return ..
	 */
	T create(T newInstance) throws Exception;

	/**
	 * Persists multiple new instances
	 *
	 * @param newInstance ..
	 * @return ..
	 */
	List<T> create(T... newInstance) throws Exception;

	/**
	 * Finds an Entity by ID
	 *
	 * @param id ..
	 * @return ..
	 */
	T retrieve(ID id) throws Exception;

	/**
	 * Retrieves all Entities of the parameterized type
	 *
	 * @return ..
	 */
	List<T> retrieveAll() throws Exception;

	/**
	 * Modifies given transient object
	 *
	 * @param transientObject ..
	 */
	T merge(T transientObject) throws Exception;

  /**
   * Modifies multiple given transient objects
   *
   * @param transientObjects
   * @return list of those merged objects
   * @throws Exception
   */
  List<T> merge(T... transientObjects) throws Exception;

	/**
	 * Removes an Entity
	 *
	 * @param persistentObject ..
	 */
	void remove(T persistentObject) throws Exception;

	/**
	 * Removes an Entity by its ID
	 *
	 * @param id ..
	 */
	void removeById(ID id) throws Exception;

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory pSessionFactory);
}