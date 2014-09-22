package de.mosaic4cap.webapp.restservice.controller;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
public abstract class RestControllerTestCase {
 private static final Logger LOGGER = Logger.getLogger(RestControllerTestCase.class);

 public abstract void testGet() throws Exception;

 public abstract void testGetAll() throws Exception;

 public abstract void testInsert() throws Exception;

 public abstract void testUpdate() throws Exception;

 public abstract void testDelete() throws Exception;

 public abstract void testDeleteByObject() throws Exception;
}
