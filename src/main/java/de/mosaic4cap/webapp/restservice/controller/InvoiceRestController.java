package de.mosaic4cap.webapp.restservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.InvoiceService;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by svenklemmer on 09.10.14.
 * <p>
 * Controller accepts data from angular frontend and
 * passes it to {@link de.mosaic4cap.webapp.restservice.services.InvoiceService} in order to
 * process it before persisting
 */
@RestController
public class InvoiceRestController extends AbstractRestController {
  private static final Logger LOGGER = Logger.getLogger(InvoiceRestController.class);

  @Autowired
  private InvoiceService service;

  //@Autowired
  //private ResponseBuilder responseBuilder;

  @RequestMapping(value = "/invoice/post",
      method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceContainer postInvoice(@RequestBody(required = true) InvoiceContainer container) {
    LOGGER.error(container);
    List<Invoice> updated = service.updateInvoices(container.getPartials());
    container.setPartials(updated);
    //return (PostResponse) responseBuilder.setListObjects(container.getPartials()).postResponse().build();
    return container;
  }
}
