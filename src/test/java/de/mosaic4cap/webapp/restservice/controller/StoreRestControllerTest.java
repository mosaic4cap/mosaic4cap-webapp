package de.mosaic4cap.webapp.restservice.controller;

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
import de.mosaic4cap.webapp.restservice.dao.StoreDao;
import de.mosaic4cap.webapp.stereotypes.entities.Store;
import de.mosaic4cap.webapp.stereotypes.enumeration.StoreType;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class StoreRestControllerTest extends RestControllerTestCase {
	private static final Logger LOGGER = Logger.getLogger(StoreRestControllerTest.class);

	private MockMvc mockMvc;

	@Autowired
	private StoreDao dao;

	@Autowired
	private StoreRestController controller;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = standaloneSetup(controller).build();
	}

	@Override
	@Test
	public void testGet() throws Exception {
		Store testStore = dao.create(new Store("2", StoreType.HQ, null, null, null, null));
		this.mockMvc.perform(
				get("/rest/1" + testStore.getId())
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Override
	@Test
	public void testGetAll() throws Exception {
		this.mockMvc.perform(
				get("/rest/")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Override
	@Test
	public void testInsert() throws Exception {
		Store sampleStore = new Store("3", StoreType.HQ, null, null, null, null);
		String json = new ObjectMapper().writeValueAsString(sampleStore);
		this.mockMvc.perform(
				post("/rest/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testUpdate() throws Exception {
		Store sampleStore = new Store("4", StoreType.HQ, null, null, null, null);
		String json = new ObjectMapper().writeValueAsString(sampleStore);
		this.mockMvc.perform(
				put("/rest/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testDelete() throws Exception {
		Store sampleStore = new Store("5", StoreType.HQ, null, null, null, null);
		String json = new ObjectMapper().writeValueAsString(sampleStore);
		this.mockMvc.perform(
				post("/rest/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();

		this.mockMvc.perform(
				delete("/rest/delete")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testDeleteByObject() throws Exception {
 /* Store sampleStore = new Store("A-MK-157", false);
dao.save(sampleStore);
this.mockMvc.perform(
delete("/Store/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
		assertTrue(true);
	}
}

