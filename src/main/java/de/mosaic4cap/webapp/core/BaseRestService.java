package de.mosaic4cap.webapp.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by Lobedan on 27.09.2014.
 */
@SuppressWarnings("unchecked")
public abstract class BaseRestService<T extends AbstractMosaic4CapEntity, ID extends Serializable> implements IBaseRestService<T, ID> {
	private static final Logger LOGGER = Logger.getLogger(BaseRestService.class);

	private CrudRepository repository;

	@Override
	public T get(long id){
		return (T) repository.findOne(id);
	}

	@Override
	public List<T> getAll(){
		return (List<T>) repository.findAll();
	}

	@Override
	public T push(T obj){
		return (T) repository.save(obj);
	}

	@Override
	public List<T> push(T... objects) {
		List<T> pushedElements = new ArrayList<>();
		Arrays.asList(objects).forEach(e -> pushedElements.add(this.push(e)));

		return pushedElements;
	}

	@Override
	public boolean delete(T obj){
		try {
			repository.delete(obj);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteById(ID id) {
		try {
			repository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public CrudRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(CrudRepository repo) {
		this.repository = repo;
	}
}
