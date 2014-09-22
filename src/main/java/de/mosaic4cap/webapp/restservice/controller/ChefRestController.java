package de.mosaic4cap.webapp.restservice.controller;

import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.ChefService;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class ChefRestController extends AbstractRestController {
    private static final Logger LOGGER = Logger.getLogger(ChefRestController.class);

    @Autowired
    private ChefService chefService;

    @RequestMapping(value = "/{store}/chef/{id}", method = RequestMethod.GET)
    public Chef get(
            @PathVariable("store") String store,
            @PathVariable("id") long id,
            @RequestParam(required = false) String mql
    ) throws Exception {
        return chefService.get(id);
    }


    @RequestMapping(value = "/{store}/chef", method = RequestMethod.GET)
    public List<Chef> getAll(
            @PathVariable("store") String store,
            @RequestParam(required = false) String mql
    ) throws Exception {
        return chefService.getAll();
    }

    @RequestMapping(value = "/{store}/chef/insert", method = RequestMethod.POST)
    public Chef insert(
            @PathVariable("store") String store,
            Chef insertObj
    ) throws Exception {
        return chefService.insert(insertObj);
    }

    @RequestMapping(value = "/{store}/chef/update", method = RequestMethod.PUT)
    public Chef update(
            @PathVariable("store") String store,
            Chef updateObj
    ) throws Exception {
        return chefService.update(updateObj);
    }

    @RequestMapping(value = "/{store}/chef/delete/{id}", method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("store") String store,
            @PathVariable("id") long objId
    ) throws Exception {
        chefService.delete(objId);
    }


    @RequestMapping(value = "/{store}/chef/delete", method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("store") String store,
            Chef deleteObj
    ) throws Exception {
        chefService.delete(deleteObj);
    }
}