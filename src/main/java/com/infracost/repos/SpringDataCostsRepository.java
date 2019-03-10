package com.infracost.repos;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class SpringDataCostsRepository implements CostsRepository {

    private CostsJPARepository costsJPARepository;

    public SpringDataCostsRepository(CostsJPARepository costsJPARepository) {
        this.costsJPARepository = costsJPARepository;
    }

    @Override
    public BigDecimal getMonthlyMaintenanceCost() {
        return new BigDecimal(
                this.costsJPARepository.findAll().iterator().next()
                        .getMonthlyMaintenanceCost());
    }

    @Override
    public BigDecimal getCostByAllCPUsInNode() {
        return new BigDecimal(
                this.costsJPARepository.findAll().iterator().next()
                        .getCostByAllCpusInNode()
        );
    }
}
