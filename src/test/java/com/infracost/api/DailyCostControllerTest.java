package com.infracost.api;

import com.infracost.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = Application.class)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class DailyCostControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    @Sql(statements = "INSERT INTO COSTS (id, monthly_maintenance_cost, cost_By_All_Cpus_In_Node) VALUES (1, 200, 100)")
    @Sql(statements = "INSERT INTO CPU_DATA (id, cpus_In_Node, cpus_Percentage_Used, cpus_Used, application) VALUES (1, 32, 0.02, 5, 'myApplication')")
    public void appCostByInstance() throws Exception {
        mvc.perform(get("/dailyCost/myApplication"))
                .andExpect(status().is(OK.value()))
                .andExpect(content().string("40.31250"));
    }


}