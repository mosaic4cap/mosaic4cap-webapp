package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.GenericDAO;
import de.mosaic4cap.webapp.stereotypes.domain.AbstractMosaicEntity;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by svenklemmer on 29.08.14.
 * implements main dao methods for generic types
 */
@SuppressWarnings("unchecked")
@ImportResource("classpath:/META-INF/mosaic4cap-persistence.xml")
public abstract class GenericHibernateDaoImpl<T extends AbstractMosaicEntity> implements GenericDAO<T> {

    private static final Logger LOGGER = Logger.getLogger(GenericHibernateDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public T create(T newInstance) throws Exception {
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                sessionFactory.getCurrentSession().save(newInstance);
                transaction.commit();
                return newInstance;
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in create @GenericDao with Class " + getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    @Transactional
    public T retrieve(Long id) throws Exception {
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                T genericObj = (T) sessionFactory.getCurrentSession().get(getClazz(), id);
                transaction.commit();
                return genericObj;
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in retrieve @GenericDao with Class " +  getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    @Transactional
    public List<T> retrieveAll() throws Exception {
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                List<T> list = sessionFactory.getCurrentSession().createQuery("from " + getClazz().getName()).list();
                transaction.commit();
                return list;
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in retrieveAll @GenericDao with Class " + getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    @Transactional
    public T merge(T transientObject) throws Exception {
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                T genericObj = (T) sessionFactory.getCurrentSession().merge(transientObject);
                transaction.commit();
                return genericObj;
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in merge @GenericDao with Class " + getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    @Transactional
    public void remove(T persistentObject) throws Exception {
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                sessionFactory.getCurrentSession().delete(persistentObject);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in remove @GenericDao with Class " + getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    @Transactional
    public void remove(Long id) throws Exception {
        T object = this.retrieve(id);
        try {
            final Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
            try {
                sessionFactory.getCurrentSession().delete(object);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                LOGGER.error("Error in remove @GenericDao with Class " + getClazz(), ex);
                throw ex;
            }
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory pSessionFactory) {
        sessionFactory = pSessionFactory;
    }

    private Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}