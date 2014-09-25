package de.mosaic4cap.webapp.restservice.dao.impl;

import java.util.List;

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
public class StoreDaoImpl extends HibernateDao<Store, Long> implements StoreDao {
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

	@Override
  @Transactional
	public Store retrieve(Long id, Long chef) throws Exception {
		try {
			final Transaction transaction = getSessionFactory().getCurrentSession().beginTransaction();
			try {
				Store store = (Store) getSessionFactory().getCurrentSession()
						.createQuery("from de.mosaic4cap.webapp.stereotypes.entities.Store WHERE id = :s_id AND chef_id = :chefa")
						.setLong("s_id", id)
						.setLong("chefa", chef)
						.uniqueResult();
				transaction.commit();
				return store;
			} catch (Exception ex) {
				transaction.rollback();
				LOGGER.error("Error in retrieve @StoreDaoImpl with Store ID " + id + " and Chef " + chef, ex);
				throw ex;
			}
		} finally {
			getSessionFactory().getCurrentSession().close();
		}
	}

	@Override
  @Transactional
	@SuppressWarnings("unchecked")
	public List<Store> retrieveAll(Long chef) throws Exception {
		try {
			final Transaction transaction = getSessionFactory().getCurrentSession().beginTransaction();
			try {
				List<Store> list = getSessionFactory().getCurrentSession()
						.createQuery("from de.mosaic4cap.webapp.stereotypes.entities.Store WHERE chef_id = :chefb")
						.setLong("chefb", chef).list();
				transaction.commit();
				return list;
			} catch (Exception ex) {
				transaction.rollback();
				LOGGER.error("Error in retrieveAll @StoreDaoImpl with Store Chef " + chef, ex);
				throw ex;
			}
		} finally {
			getSessionFactory().getCurrentSession().close();
		}
	}
}
