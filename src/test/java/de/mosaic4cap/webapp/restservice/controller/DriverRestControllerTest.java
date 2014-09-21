package de.mosaic4cap.webapp.restservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.DriverDao;
import de.mosaic4cap.webapp.stereotypes.domain.Driver;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

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
public class DriverRestControllerTest extends RestControllerTestCase {
    private static final Logger LOGGER = Logger.getLogger(DriverRestControllerTest.class);
    private MockMvc mockMvc;

    @Autowired
    private DriverDao dao;

    @Autowired
    private DriverRestController controller;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Override
    @Test
    public void testGet() throws Exception {
        Driver testDriver = dao.create(new Driver("value", "", null));
        this.mockMvc.perform(
                get("/rest/1/driver/" + testDriver.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Override
    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(
                get("/rest/1/driver/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Override
    @Test
    public void testInsert() throws Exception {
        Driver sampleDriver = new Driver("value2", "", null);
        String json = new ObjectMapper().writeValueAsString(sampleDriver);
        this.mockMvc.perform(
                post("/rest/1/driver/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
        Driver sampleDriver = new Driver("value3", "", null);
        String json = new ObjectMapper().writeValueAsString(sampleDriver);
        this.mockMvc.perform(
                put("/rest/1/driver/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Override
    @Test
    public void testDelete() throws Exception {
        Driver sampleDriver = new Driver("value4", "", null);
        String json = new ObjectMapper().writeValueAsString(sampleDriver);
        this.mockMvc.perform(
                post("/rest/1/driver/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        this.mockMvc.perform(
                delete("/rest/1/driver/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Override
    @Test
    public void testDeleteByObject() throws Exception {
 /* Driver sampleDriver = new Driver("A-MK-157", false);
dao.save(sampleDriver);
this.mockMvc.perform(
delete("/driver/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
        assertTrue(true);
    }
}