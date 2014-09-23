package de.mosaic4cap.webapp.chefui.definitions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Lobedan on 24.09.2014.
 * <p>
 * ControllerAdvice to push storedata directly into thymleaf
 * it uses {@link de.mosaic4cap.webapp.restservice.controller.StoreRestController} to get all
 * data and push it with {@link org.springframework.web.bind.annotation.ModelAttribute} into
 * html template
 */
@ControllerAdvice
public class StoreDefinitions {
	private static final Logger LOGGER = Logger.getLogger(StoreDefinitions.class);

	@ModelAttribute(value = "allStores")
	public List getAllStores() {
		List<Object> l = new ArrayList<>();
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		return l;
	}
}
