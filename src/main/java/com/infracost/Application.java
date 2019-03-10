package com.infracost;

import com.infracost.domain.ApplicationCostByInstanceUseCase;
import com.infracost.domain.DailyCost;
import com.infracost.repos.CostsRepository;
import com.infracost.repos.CpusRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    ApplicationCostByInstanceUseCase applicationCostByInstanceUseCase(CpusRepository cpusRepository,
                                                                      CostsRepository costsRepository) {
        return new ApplicationCostByInstanceUseCase(new DailyCost(), cpusRepository, costsRepository);
    }
}
