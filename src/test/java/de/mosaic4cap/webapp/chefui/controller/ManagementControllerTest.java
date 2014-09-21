package de.mosaic4cap.webapp.chefui.controller;

import de.mosaic4cap.webapp.Application;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Lobedan on 21.09.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ManagementControllerTest {
    private static final Logger LOGGER = Logger.getLogger(HomeControllerTest.class);

    @Autowired
    private ManagementController controller;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void storeRouteIsAccessable() throws Exception {
        this.mockMvc.perform(
                get("/chefui/manage/store"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void employeeRouteIsAccessable() throws Exception {
        this.mockMvc.perform(
                get("/chefui/manage/employee"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}