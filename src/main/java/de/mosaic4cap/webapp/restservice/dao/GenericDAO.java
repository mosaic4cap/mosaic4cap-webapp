package de.mosaic4cap.webapp.restservice.dao;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by svenklemmer on 29.08.14.
 * Basic CRUD operations. Based on pattern "genericDAO".
 * Because all our Entities have an ID of type "long", we don't need to generify
 * the ID though.
 */
public interface GenericDAO<T> {
    /**
     * Persists a new Instance
     *
     * @param newInstance ..
     * @return ..
     */
    T create(T newInstance) throws Exception;

    /**
     * Finds an Entity by ID
     *
     * @param id ..
     * @return ..
     */
    T retrieve(Long id) throws Exception;

    /**
     * Retrieves all Entities of the parameterized type
     *
     * @return ..
     */
    List<T> retrieveAll() throws Exception;

    /**
     * Reattaches a transient Entity to the persistenceContext
     *
     * @param transientObject ..
     */
    T merge(T transientObject) throws Exception;

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
    void remove(Long id) throws Exception;

    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory pSessionFactory);
}