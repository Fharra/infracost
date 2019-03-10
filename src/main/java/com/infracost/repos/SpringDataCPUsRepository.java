package com.infracost.repos;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class SpringDataCPUsRepository implements CpusRepository {

    private CpusJPARepository cpusJPARepository;

    public SpringDataCPUsRepository(CpusJPARepository cpusJPARepository) {
        this.cpusJPARepository = cpusJPARepository;
    }

    @Override
    public BigDecimal getCpusInNode() {
        return new BigDecimal(
                cpusJPARepository.findAll().iterator().next()
                        .getCpusInNode()
        );
    }

    @Override
    public BigDecimal getCpusPercentageUsed(String myApplication) {
        return new BigDecimal(
                cpusJPARepository.findByApplication(myApplication).getCpusPercentageUsed()
        );
    }

    @Override
    public BigDecimal getCpusUsed(String myApplication) {
        return new BigDecimal(
                cpusJPARepository.findByApplication(myApplication).getCpusUsed()
        );
    }
}
