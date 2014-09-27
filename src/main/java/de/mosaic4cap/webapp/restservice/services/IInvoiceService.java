package de.mosaic4cap.webapp.restservice.services;

import java.util.List;

import de.mosaic4cap.webapp.core.IBaseRestService;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 27.09.2014.
 */
public interface IInvoiceService extends IBaseRestService<Invoice, Long> {
	List<Invoice> getAllByStoreId(long storeId);
	public List<InvoiceContainer> getGroupedInvoices(long storeid);
}