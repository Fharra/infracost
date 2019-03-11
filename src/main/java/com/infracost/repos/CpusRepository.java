package com.infracost.repos;

import java.math.BigDecimal;

public interface CpusRepository {
    BigDecimal getCpusInNode();
    BigDecimal getCpusPercentageUsed(String myApplication);
    BigDecimal getCpusUsed(String myApplication);
}
