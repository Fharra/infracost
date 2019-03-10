package com.infracost.repos;

import org.springframework.data.repository.CrudRepository;

public interface CpusJPARepository extends CrudRepository <CpuData, Long> {

    CpuData findByApplication(String application);
}
