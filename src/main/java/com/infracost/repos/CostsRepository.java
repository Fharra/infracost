package com.infracost.repos;

import java.math.BigDecimal;

public interface CostsRepository {
    BigDecimal getMonthlyMaintenanceCost();
    BigDecimal getCostByAllCPUsInNode();
}
