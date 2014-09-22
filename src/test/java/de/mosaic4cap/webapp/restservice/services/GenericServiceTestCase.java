package de.mosaic4cap.webapp.restservice.services;

/**
 * Created by Lobedan on 30.08.2014.
 */
public abstract class GenericServiceTestCase {
	public abstract void testInsert() throws Exception;

	public abstract void testGet() throws Exception;

	public abstract void testGetAll() throws Exception;

	public abstract void testUpdate() throws Exception;

	public abstract void testDeleteByObject() throws Exception;

	public abstract void testDeleteById() throws Exception;
}
