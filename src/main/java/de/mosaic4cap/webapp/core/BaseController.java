package de.mosaic4cap.webapp.core;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 15.09.14.
 * <p>
 * BaseController for all Controller used by most of services
 * <p>
 * If a Controller doesnt need to implement a method
 * just leave it out
 */
public abstract class BaseController<T> {
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);

	public T get(long id) throws Exception {
		return null;
	}

	public List<T> getAll() throws Exception {
		return null;
	}

	public T post(T obj) throws Exception {
		return null;
	}

	public T put(T obj) throws Exception {
		return null;
	}

	public boolean delete(T obj) throws Exception {
		return false;
	}

	public boolean delete(long id) throws Exception {
		return delete(get(id));
	}
}
