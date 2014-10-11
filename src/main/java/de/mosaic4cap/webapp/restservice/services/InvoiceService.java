package de.mosaic4cap.webapp.restservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mosaic4cap.webapp.core.BaseRestService;
import de.mosaic4cap.webapp.restservice.repository.InvoiceRepository;
import de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

/**
 * Created by Lobedan on 27.09.2014.
 */
@Service
public class InvoiceService extends BaseRestService<Invoice, Long> implements IInvoiceService {
  private static final Logger LOGGER = Logger.getLogger(InvoiceService.class);

  private InvoiceRepository repository;

  @Autowired
  public void setRepository(InvoiceRepository repo) {
    repository = repo;
    super.setRepository(repo);
  }

  @Override
  public List<Invoice> getAllByStoreId(long storeId) {
    return repository.findByStoreId(storeId);
  }

  @Override
  public List<InvoiceContainer> getGroupedInvoices(long storeid) {
    List<InvoiceContainer> invoiceContainers = new ArrayList<>();

    try {
      List<Invoice> allInvoices = repository.findByStoreId(storeid);

      Map<Date, List<Invoice>> hashMap = new HashMap<>();

      for (Invoice i : allInvoices) {
        if (!hashMap.containsKey(i.getModDate())) {
          List<Invoice> list = new ArrayList<>();
          list.add(i);
          hashMap.put(i.getModDate(), list);
        } else {
          hashMap.get(i.getModDate()).add(i);
        }
      }
      //just modify chef in every invoice
      hashMap.entrySet().forEach(entry -> /*{
                                   entry.getValue().get(0).getStore().setChef(null);
																	 entry.getValue().get(0).getStore().setCars(null);
																	 entry.getValue().get(0).getStore().setDrivers(null);
																	 entry.getValue().get(0).getStore().getInvoices().forEach(i -> {
																		 i.setStore(null);
																		 i.getDriver().setStore(null);
																		 i.getCar().setStore(null);
																	 });*/
                                     invoiceContainers.add(new InvoiceContainer(entry.getKey(),
                                                                                entry.getValue(),
                                                                                entry.getValue().get(0).getStore()))
                                 //}
      );
    } catch (Exception e) {
      LOGGER.error(e);
    }
    return invoiceContainers;
  }

  @Override
  public List<Invoice> updateInvoices(List<Invoice> invoices) {
    //is list empty? then return a empty list
    if (invoices.size() == 0) {
      return new ArrayList<>();
    }
    if (invoices.contains(null)) {
      throw new IllegalArgumentException("ArrayList may not contain null element @" + this.getClass().getName());
    }
    repository.save(invoices); //assume nothing bad happend, then return input invoices
    return invoices;
  }
}
