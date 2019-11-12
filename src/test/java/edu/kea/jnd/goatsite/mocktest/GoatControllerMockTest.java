package edu.kea.jnd.goatsite.mocktest;

import edu.kea.jnd.goatsite.controller.api.GoatApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

public class GoatControllerMockTest {
    @RunWith(SpringRunner.class)
    @WebMvcTest(GoatApiController.class)
    public class EmployeeRestControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;


        @Test
        public void canGetGoats() throws Exception{
            mockMvc.perform(get("/api/goats")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        }
    }
}
