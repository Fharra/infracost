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
public class SpringDataCPUsRepositoryIT {

    @Autowired
    SpringDataCPUsRepository repository;

    @Test
    @Sql(statements = "INSERT INTO CPU_DATA (id, cpus_In_Node, cpus_Percentage_Used, cpus_Used, application) VALUES (1, 32, 20, 5, 'myApplication')")
    public void getCpusInNode() {
        assertThat(repository.getCpusInNode(), is(new BigDecimal(32)));
    }

    @Test
    @Sql(statements = "INSERT INTO CPU_DATA (id, cpus_In_Node, cpus_Percentage_Used, cpus_Used, application) VALUES (2, 32, 20, 5, 'mySecondApplication')")
    public void getCpusPercentageUsed() {
        assertThat(repository.getCpusPercentageUsed("mySecondApplication"), is(new BigDecimal(20)));
    }

    @Test
    @Sql(statements = "INSERT INTO CPU_DATA (id, cpus_In_Node, cpus_Percentage_Used, cpus_Used, application) VALUES (3, 32, 20, 5,  'myThirdApplication')")
    public void getCpusUsed() {
        assertThat(repository.getCpusUsed("myThirdApplication"), is(new BigDecimal(5)));
    }

    @Configuration
    @EnableAutoConfiguration
    @Import(SpringDataCPUsRepository.class)
    @EnableJpaRepositories(basePackageClasses = SpringDataCPUsRepository.class)
    public static class Conf {

    }
}