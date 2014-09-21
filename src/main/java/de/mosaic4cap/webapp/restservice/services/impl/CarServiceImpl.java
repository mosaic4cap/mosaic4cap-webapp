package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.restservice.dao.CarDao;
import de.mosaic4cap.webapp.restservice.services.CarService;
import de.mosaic4cap.webapp.stereotypes.domain.Car;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class CarServiceImpl extends AbstractGenericService<Car> implements CarService {
    private static final Logger LOGGER = Logger.getLogger(CarServiceImpl.class);

    public CarServiceImpl() {
    }

    @Autowired
    public CarServiceImpl(CarDao dao) {
        super.setDao(dao);
    }
}
