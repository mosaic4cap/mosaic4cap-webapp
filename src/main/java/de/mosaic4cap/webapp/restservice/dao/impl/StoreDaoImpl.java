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
						.createQuery("from de.mosaic4cap.webapp.stereotypes.entities.Store WHERE store_key = '" + key + "'").uniqueResult();
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


//  Caused by: org.h2.jdbc.JdbcSQLException:
// Datenumwandlungsfehler beim Umwandeln von "'A01'
// (chef: ""id"" BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_4F8ED3A3_252F_4DC5_B6EF_AEE19752044B) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_4F8ED3A3_252F_4DC5_B6EF_AEE19752044B)"
//  Data conversion error converting "'A01' (chef: ""id"" BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_4F8ED3A3_252F_4DC5_B6EF_AEE19752044B) NOT NULL NULL_TO_DEFAULT SEQUENCE
// PUBLIC.SYSTEM_SEQUENCE_4F8ED3A3_252F_4DC5_B6EF_AEE19752044B)"; SQL statement:
//  INSERT INTO store (id, store_key, chef_id) VALUES (1, 'A01', 1), (2, 'A02', 1), (3, 'A03', 1) [22018-181]

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
