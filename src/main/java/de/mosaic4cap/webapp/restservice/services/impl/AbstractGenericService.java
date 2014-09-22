package de.mosaic4cap.webapp.restservice.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.restservice.dao.GenericDAO;
import de.mosaic4cap.webapp.restservice.services.GenericService;

/**
 * Created by Lobedan on 30.08.2014.
 */
public abstract class AbstractGenericService<T> implements GenericService<T> {
	private static final Logger LOGGER = Logger.getLogger(AbstractGenericService.class);

	private GenericDAO<T> dao;

	@Override
	public T insert(T newInstance) throws Exception {
		return dao.create(newInstance);
	}

	@Override
	public T get(Long id) throws Exception {
		return dao.retrieve(id);
	}

	@Override
	public List<T> getAll() throws Exception {
		List<T> entitiyList = dao.retrieveAll();
		LOGGER.info("received object list: " + entitiyList);
		return entitiyList;
	}

	@Override
	public T update(T transientObject) throws Exception {
		return dao.merge(transientObject);
	}

	@Override
	public void delete(T persistentObject) throws Exception {
		dao.remove(persistentObject);
	}

	@Override
	public void delete(Long id) throws Exception {
		dao.remove(id);
	}

	@Override
	public GenericDAO<T> getDao() {
		return dao;
	}

	@Override
	public void setDao(GenericDAO<T> pDao) {
		this.dao = pDao;
	}
}
