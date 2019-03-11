package com.infracost.domain;

import com.infracost.repos.CostsRepository;
import com.infracost.repos.CpusRepository;

import java.math.BigDecimal;

public class ApplicationCostByInstanceUseCase {
    private DailyCost dailyCost;
    private CpusRepository cpusRepo;
    private CostsRepository costsRepo;

    public ApplicationCostByInstanceUseCase(DailyCost dailyCost, CpusRepository cpusRepository,
                                            CostsRepository costsRepository) {
        this.dailyCost = dailyCost;
        this.cpusRepo = cpusRepository;
        this.costsRepo = costsRepository;
    }

    public BigDecimal costByInstance(String myApplication) {
        return dailyCost.getTotalInstanceCost(cpusRepo.getCpusInNode(), cpusRepo.getCpusPercentageUsed(myApplication),
                cpusRepo.getCpusUsed(myApplication), costsRepo.getMonthlyMaintenanceCost(),
                costsRepo.getCostByAllCPUsInNode());
    }
}
