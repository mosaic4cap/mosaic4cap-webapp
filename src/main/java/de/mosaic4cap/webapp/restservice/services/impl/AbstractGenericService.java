package de.mosaic4cap.webapp.restservice.services.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import de.mosaic4cap.webapp.restservice.dao.GenericDAO;
import de.mosaic4cap.webapp.restservice.services.GenericService;
import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by Lobedan on 30.08.2014.
 */
public abstract class AbstractGenericService<T extends AbstractMosaic4CapEntity, ID extends Serializable> implements GenericService<T, ID> {
	private static final Logger LOGGER = Logger.getLogger(AbstractGenericService.class);

	private GenericDAO<T, ID> dao;

	@Override
	@Transactional
	public T insert(T newInstance) throws Exception {
		return dao.create(newInstance);
	}

	@Override
	@Transactional
	public T get(ID id) throws Exception {
		return dao.retrieve(id);
	}

	@Override
	@Transactional
	public List<T> getAll() throws Exception {
		List<T> entitiyList = dao.retrieveAll();
		LOGGER.info("received object list: " + entitiyList);
		return entitiyList;
	}

	@Override
	@Transactional
	public T update(T transientObject) throws Exception {
		return dao.merge(transientObject);
	}

	@Override
	@Transactional
	public void delete(T persistentObject) throws Exception {
		dao.remove(persistentObject);
	}

	@Override
	@Transactional
	public void delete(ID id) throws Exception {
		dao.removeById(id);
	}

	@Override
	public GenericDAO<T, ID> getDao() {
		return dao;
	}

	@Override
	public void setDao(GenericDAO<T, ID> pDao) {
		this.dao = pDao;
	}
}
