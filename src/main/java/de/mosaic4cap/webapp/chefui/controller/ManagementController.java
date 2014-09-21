package de.mosaic4cap.webapp.chefui.controller;

import de.mosaic4cap.webapp.core.AbstractChefUIController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by svenklemmer on 18.09.14.
 * <p/>
 * Controller for all management views like store, employee etc.
 */
@Controller
public class ManagementController extends AbstractChefUIController {
    private static final Logger LOGGER = Logger.getLogger(ManagementController.class);

    @RequestMapping("/manage/store")
    public String loadStores() throws Exception {
        return "chefui/store";
    }

    @RequestMapping("/manage/employee")
    public String loadEmployees() throws Exception {
        return "chefui/employee";
    }
}
