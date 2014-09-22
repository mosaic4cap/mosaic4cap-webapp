package de.mosaic4cap.webapp.restservice.dao;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
public abstract class GenericHibernateDaoTestCase {
	private static final Logger LOGGER = Logger.getLogger(GenericHibernateDaoTestCase.class);

	public abstract void testCreate() throws Exception;

	public abstract void testRetrieve() throws Exception;

	public abstract void testRetrieveAll() throws Exception;

	public abstract void testMerge() throws Exception;

	public abstract void testRemoveByObject() throws Exception;

	public abstract void testRemoveById() throws Exception;
}
