package de.mosaic4cap.webapp.restservice.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.restservice.services.StoreService;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class StoreServiceImpl extends AbstractGenericService<Store> implements StoreService {
 private static final Logger LOGGER = Logger.getLogger(StoreServiceImpl.class);

 private StoreDao sDao;

 public StoreServiceImpl() {
 }

 @Autowired
 public StoreServiceImpl(StoreDao dao) {
	super.setDao(dao);
	this.sDao = dao;
 }

 @Override
 public Store retrieve(String key) throws Exception {
	return sDao.retrieve(key);
 }

 @Override
 public void remove(String key) throws Exception {
	sDao.remove(key);
 }
}
