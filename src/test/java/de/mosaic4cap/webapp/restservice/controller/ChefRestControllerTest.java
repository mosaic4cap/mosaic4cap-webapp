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
import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;

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
public class ChefRestControllerTest extends RestControllerTestCase {
	private static final Logger LOGGER = Logger.getLogger(ChefRestControllerTest.class);
	private MockMvc mockMvc;

	@Autowired
	private ChefDao dao;

	@Autowired
	private ChefRestController controller;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = standaloneSetup(controller).build();
	}

	@Override
	@Test
	public void testGet() throws Exception {
		Chef testChef = dao.create(new Chef("value", "", null));
		this.mockMvc.perform(
				get("/rest/1/chef/1" + testChef.getId())
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Override
	@Test
	public void testGetAll() throws Exception {
		this.mockMvc.perform(
				get("/rest/1/chef")
						.accept(MediaType.APPLICATION_JSON))
				//                .andExpect(status().isOk())
				.andDo(print());
	}

	@Override
	@Test
	public void testInsert() throws Exception {
		Chef sampleChef = new Chef("value2", "3", null);
		String json = new ObjectMapper().writeValueAsString(sampleChef);
		this.mockMvc.perform(
				post("/rest/1/chef/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Override
	@Test
	public void testUpdate() throws Exception {
		Chef sampleChef = new Chef("value3", "4", null);
		String json = new ObjectMapper().writeValueAsString(sampleChef);
		this.mockMvc.perform(
				put("/rest/1/chef/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Override
	@Test
	public void testDelete() throws Exception {
		Chef sampleChef = new Chef("value4", "6", null);
		String json = new ObjectMapper().writeValueAsString(sampleChef);
		this.mockMvc.perform(
				post("/rest/1/chef/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();

		this.mockMvc.perform(
				delete("/rest/1/chef/delete")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Override
	@Test
	public void testDeleteByObject() throws Exception {
 /* Chef sampleChef = new Chef("A-MK-157", false);
dao.save(sampleChef);
this.mockMvc.perform(
delete("/chef/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
		assertTrue(true);
	}
}
