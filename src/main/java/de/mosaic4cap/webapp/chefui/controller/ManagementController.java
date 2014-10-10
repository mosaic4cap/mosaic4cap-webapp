package de.mosaic4cap.webapp.chefui.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mosaic4cap.webapp.core.AbstractChefUIController;

/**
 * Created by svenklemmer on 18.09.14.
 * <p>
 * Controller for all management views like store, employee etc.
 */
@Controller
public class ManagementController extends AbstractChefUIController {
	private static final Logger LOGGER = Logger.getLogger(ManagementController.class);

	@RequestMapping("/manage/store")
	public String loadStores() throws Exception {
		return "chefui/store";
	}

	@RequestMapping("/manage/sales")
	public String loadSales() throws Exception {
		return "chefui/sales";
	}
}
