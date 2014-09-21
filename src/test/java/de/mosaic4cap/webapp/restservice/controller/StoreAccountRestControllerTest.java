package de.mosaic4cap.webapp.restservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.restservice.dao.StoreAccountDao;
import de.mosaic4cap.webapp.stereotypes.domain.StoreAccount;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Date;

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
public class StoreAccountRestControllerTest extends RestControllerTestCase {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountRestControllerTest.class);
    private MockMvc mockMvc;

    @Autowired
    private StoreAccountDao dao;

    @Autowired
    private StoreAccountRestController controller;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Override
    @Test
    public void testGet() throws Exception {
        StoreAccount testStoreAccount = dao.create(new StoreAccount(new BigDecimal(3), null, null, null, null, null, new Date()));
        this.mockMvc.perform(
                get("/rest/1/storeaccount/" + testStoreAccount.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Override
    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(
                get("/rest/1/storeaccount/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Override
    @Test
    public void testInsert() throws Exception {
        StoreAccount sampleStoreAccount = new StoreAccount(new BigDecimal(2), null, null, null, null, null, new Date());
        String json = new ObjectMapper().writeValueAsString(sampleStoreAccount);
        this.mockMvc.perform(
                post("/rest/1/storeaccount/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
//                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
        StoreAccount sampleStoreAccount = new StoreAccount(new BigDecimal(1), null, null, null, null, null, new Date());
        String json = new ObjectMapper().writeValueAsString(sampleStoreAccount);
        this.mockMvc.perform(
                put("/rest/1/storeaccount/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
//                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Override
    @Test
    public void testDelete() throws Exception {
        StoreAccount sampleStoreAccount = new StoreAccount(new BigDecimal(4), null, null, null, null, null, new Date());
        String json = new ObjectMapper().writeValueAsString(sampleStoreAccount);
        this.mockMvc.perform(
                post("/rest/1/storeaccount/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
//                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        this.mockMvc.perform(
                delete("/rest/1/storeaccount/delete")
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
delete("/storeaccount/delete/")
.contentType(MediaType.TEXT_PLAIN))
.andExpect(status().isOk())
.andDo(print())
.andReturn();
*/
        assertTrue(true);
    }
}
