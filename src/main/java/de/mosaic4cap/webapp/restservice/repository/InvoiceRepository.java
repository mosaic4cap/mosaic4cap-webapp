package de.mosaic4cap.webapp.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> { }