package com.infracost.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DailyCostTest {

    // General prices
    BigDecimal costByAllCPUsInNode = new BigDecimal(100);
    BigDecimal monthlyMaintenanceCost = new BigDecimal(200);
    BigDecimal cpusInNode = new BigDecimal(32);

    // Consumption data
    BigDecimal cpusUsed = new BigDecimal(5);
    BigDecimal cpusPercentageUsed = new BigDecimal("0.02");

    @Test
    public void given5CPUConsumedByAnInstance_With100EurCostForThisNodesAllCPUS() {

        DailyCost dailyCost = new DailyCost();
        BigDecimal totalAmountForCpuConsumption = dailyCost.getTotalInstanceCost(cpusInNode, cpusPercentageUsed,
                cpusUsed, monthlyMaintenanceCost, costByAllCPUsInNode);

        BigDecimal costForConsumedCPUInInstanceAndNode = new BigDecimal("40.31250");
        assertEquals(costForConsumedCPUInInstanceAndNode, totalAmountForCpuConsumption);
    }
}
