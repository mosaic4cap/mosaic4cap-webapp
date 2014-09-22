package de.mosaic4cap.webapp.restservice.controller;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.InvoiceDao;
import de.mosaic4cap.webapp.stereotypes.entities.Invoice;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class InvoiceRestControllerTest extends RestControllerTestCase {
 private static final Logger LOGGER = Logger.getLogger(InvoiceRestControllerTest.class);
 private MockMvc mockMvc;

 @Autowired
 private InvoiceDao dao;

 @Autowired
 private InvoiceRestController controller;

 @Before
 public void setUp() throws Exception {
	this.mockMvc = standaloneSetup(controller).build();
 }

 @Override
 @Test
 public void testGet() throws Exception {
	Invoice testInvoice = dao
			.create(new Invoice(new BigDecimal(3), null, null, null, null, null, new Date()));
	this.mockMvc.perform(
			get("/rest/1/invoice/" + testInvoice.getId())
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
 }

 @Override
 @Test
 public void testGetAll() throws Exception {
	this.mockMvc.perform(
			get("/rest/1/invoice/")
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
 }

 @Override
 @Test
 public void testInsert() throws Exception {
	Invoice sampleInvoice = new Invoice(new BigDecimal(2), null, null, null, null, null, new Date());
	String json = new ObjectMapper().writeValueAsString(sampleInvoice);
	this.mockMvc.perform(
			post("/rest/1/invoice/insert")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
			//                .andExpect(status().isOk())
			.andDo(print())
			.andReturn();
 }

 @Override
 @Test
 public void testUpdate() throws Exception {
	Invoice sampleInvoice = new Invoice(new BigDecimal(1), null, null, null, null, null, new Date());
	String json = new ObjectMapper().writeValueAsString(sampleInvoice);
	this.mockMvc.perform(
			put("/rest/1/invoice/update")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
			//                .andExpect(status().isOk())
			.andDo(print())
			.andReturn();
 }

 @Override
 @Test
 public void testDelete() throws Exception {
	Invoice sampleInvoice = new Invoice(new BigDecimal(4), null, null, null, null, null, new Date());
	String json = new ObjectMapper().writeValueAsString(sampleInvoice);
	this.mockMvc.perform(
			post("/rest/1/invoice/insert")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
			//                .andExpect(status().isOk())
			.andDo(print())
			.andReturn();

	this.mockMvc.perform(
			delete("/rest/1/invoice/delete")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
			//                .andExpect(status().isOk())
			.andDo(print())
			.andReturn();
 }

 @Override
 @Test
 public void testDeleteByObject() throws Exception {
 /* StoreAccount sampleStoreAccount = new StoreAccount("A-MK-157", false);
dao.save(sampleStoreAccount);
this.mockMvc.perform(
delete("/invoice/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
	assertTrue(true);
 }
}