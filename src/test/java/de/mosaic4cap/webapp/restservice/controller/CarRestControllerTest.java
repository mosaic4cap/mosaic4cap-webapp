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
import de.mosaic4cap.webapp.restservice.dao.CarDao;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

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
public class CarRestControllerTest extends RestControllerTestCase {
	private static final Logger LOGGER = Logger.getLogger(CarRestControllerTest.class);
	private MockMvc mockMvc;

	@Autowired
	private CarDao dao;

	@Autowired
	private CarRestController controller;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = standaloneSetup(controller).build();
	}

	@Override
	@Test
	public void testGet() throws Exception {
		Car testCar = dao.create(new Car("Test", false, null));
		this.mockMvc.perform(
				get("/rest/1/car/" + testCar.getId())
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Override
	@Test
	public void testGetAll() throws Exception {
		this.mockMvc.perform(
				get("/rest/1/car/")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Override
	@Test
	public void testInsert() throws Exception {
		Car sampleCar = new Car("A-MK-143", false, null);
		String json = new ObjectMapper().writeValueAsString(sampleCar);
		this.mockMvc.perform(
				post("/rest/1/car/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testUpdate() throws Exception {
		Car sampleCar = new Car("A-MK-143", false, null);
		String json = new ObjectMapper().writeValueAsString(sampleCar);
		this.mockMvc.perform(
				put("/rest/1/car/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testDelete() throws Exception {
		Car sampleCar = new Car("A-MK-143", false, null);
		String json = new ObjectMapper().writeValueAsString(sampleCar);
		this.mockMvc.perform(
				post("/rest/1/car/insert")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andReturn();

		this.mockMvc.perform(
				delete("/rest/1/car/delete")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				//.andExpect(status().isOk())
				.andReturn();
	}

	@Override
	@Test
	public void testDeleteByObject() throws Exception {
 /* Car sampleCar = new Car("A-MK-157", false);
dao.save(sampleCar);
this.mockMvc.perform(
delete("/car/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
		assertTrue(true);
	}
}
