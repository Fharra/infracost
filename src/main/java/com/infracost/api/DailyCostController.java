package com.infracost.api;

import com.infracost.domain.ApplicationCostByInstanceUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyCostController {

    private ApplicationCostByInstanceUseCase useCase;

    public DailyCostController(ApplicationCostByInstanceUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/dailyCost/{application}")
    public String getDailyCost(@PathVariable String application){
        return useCase.costByInstance(application).toPlainString();
    }
}
