package com.infracost.domain;

import java.math.BigDecimal;

public class DailyCost {

    public BigDecimal getTotalInstanceCost(BigDecimal cpusInNode, BigDecimal cpusPercentageUsed, BigDecimal cpusUsed,
                                           BigDecimal monthlyMaintenanceCost, BigDecimal costByAllCPUsInNode) {

        BigDecimal energyUsed = cpusUsed.multiply(costByAllCPUsInNode)
                .divide(cpusInNode)
                .multiply(cpusPercentageUsed);
        BigDecimal serverCostPerInstance = monthlyMaintenanceCost.divide(cpusUsed);

        return energyUsed.add(serverCostPerInstance);
    }
}


