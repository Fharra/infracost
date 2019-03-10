package com.infracost.domain;

import com.infracost.repos.CostsRepository;
import com.infracost.repos.CpusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationCostByInstanceUseCaseTest {

    @Mock
    CpusRepository cpusRepository;
    @Mock
    CostsRepository costsRepository;

    @Test
    public void getsInstanceCost() {
        when(cpusRepository.getCpusInNode()).thenReturn(new BigDecimal(32));
        when(cpusRepository.getCpusPercentageUsed("myApplication")).thenReturn(new BigDecimal("0.02"));
        when(cpusRepository.getCpusUsed("myApplication")).thenReturn(new BigDecimal(5));
        when(costsRepository.getCostByAllCPUsInNode()).thenReturn(new BigDecimal(100));
        when(costsRepository.getMonthlyMaintenanceCost()).thenReturn(new BigDecimal(200));
        ApplicationCostByInstanceUseCase useCase = new ApplicationCostByInstanceUseCase(new DailyCost(),
                cpusRepository, costsRepository);

        BigDecimal cost = useCase.costByInstance("myApplication");

        assertThat(cost, is(new BigDecimal("40.31250")));
    }
}
