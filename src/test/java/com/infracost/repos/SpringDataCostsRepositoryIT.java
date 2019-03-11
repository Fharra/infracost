package com.infracost.repos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class SpringDataCostsRepositoryIT {

    @Autowired
    SpringDataCostsRepository repository;

    @Test
    @Sql(statements = "INSERT INTO COSTS (id, monthly_maintenance_cost, cost_By_All_Cpus_In_Node) VALUES (1, 200, 100)")
    public void getMonthlyMaintenanceCost() {
        assertThat(repository.getMonthlyMaintenanceCost(), is(new BigDecimal(200)));
    }

    @Test
    @Sql(statements = "INSERT INTO COSTS (id, monthly_maintenance_cost, cost_By_All_Cpus_In_Node) VALUES (2, 200, 100)")
    public void getCostByAllCPUsInNode() {
        assertThat(repository.getCostByAllCPUsInNode(), is(new BigDecimal(100)));
    }

    @Configuration
    @Import(SpringDataCostsRepository.class)
    @EnableJpaRepositories(basePackageClasses = CostsJPARepository.class)
    @EnableAutoConfiguration
    public static class Conf {

    }
}