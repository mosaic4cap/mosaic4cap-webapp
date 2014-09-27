package de.mosaic4cap.webapp.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.AbstractMosaic4CapEntity;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface IBaseRestService<T extends AbstractMosaic4CapEntity, ID extends Serializable> {

	public T get(long id);

	public List<T> getAll();

	public T push(T obj);

	public List<T> push(T... objects);

	public boolean delete(T obj);

	public boolean deleteById(ID id);

	public CrudRepository getRepository();

	public void setRepository(CrudRepository repo);

}
