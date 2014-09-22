package de.mosaic4cap.webapp.restservice.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by svenklemmer on 29.08.14.
 */
@Dao
public class StoreDaoImpl extends GenericHibernateDaoImpl<Store> implements StoreDao {
 private static final Logger LOGGER = Logger.getLogger(StoreDaoImpl.class);

 @Override
 @Transactional
 public Store retrieve(String key) throws Exception {
	try {
	 final Transaction transaction = getSessionFactory().getCurrentSession().beginTransaction();
	 try {
		Store store = (Store) getSessionFactory().getCurrentSession()
				.createQuery("from de.mosaic4cap.webapp.stereotypes.entities.Store WHERE store_key = :s_key")
				.setString(":s_key", key).uniqueResult();
		transaction.commit();
		return store;
	 } catch (Exception ex) {
		transaction.rollback();
		LOGGER.error("Error in retrieve @StoreDaoImpl with Store Key " + key, ex);
		throw ex;
	 }
	} finally {
	 getSessionFactory().getCurrentSession().close();
	}
 }

 @Override
 @Transactional
 public void remove(String key) throws Exception {
	Store store = this.retrieve(key);
	super.remove(store);
 }
}
