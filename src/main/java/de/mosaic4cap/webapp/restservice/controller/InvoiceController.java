package de.mosaic4cap.webapp.restservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.core.BaseRestController;
import de.mosaic4cap.webapp.core.ResponseBuilder;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.PostResponse;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;

/**
 * Created by svenklemmer on 09.10.14.
 * <p>
 * Controller accepts data from angular frontend and
 * passes it to {@link de.mosaic4cap.webapp.restservice.services.InvoiceService} in order to
 * process it before persisting
 */
@RestController
public class InvoiceController extends BaseRestController {
  private static final Logger LOGGER = Logger.getLogger(InvoiceController.class);

  @Autowired
  private InvoiceService service;

  @Autowired
  private ResponseBuilder responseBuilder;

  @RequestMapping(value = "/invoice/post",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public PostResponse postInvoice(@RequestBody InvoiceContainer container) {
    LOGGER.info(container.getPartials());
    service.updateInvoices(container.getPartials());

    //TODO: still lacks that json cant be mapped to items with same id twice maybe its possible to include some timestamp for id (#16)

    //if nothing bad happend then return a standard post response
    LOGGER.info(responseBuilder.setListObjects(service.getGroupedInvoices(container.getStore().getId())).postResponse().build());
    return (PostResponse) responseBuilder.setListObjects(service.getGroupedInvoices(container.getStore().getId())).postResponse().build();
  }
}
