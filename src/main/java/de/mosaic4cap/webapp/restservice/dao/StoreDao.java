package de.mosaic4cap.webapp.restservice.dao;

import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
public interface StoreDao extends GenericDAO<Store> {

 public Store retrieve(String key) throws Exception;

 public void remove(String key) throws Exception;
}
