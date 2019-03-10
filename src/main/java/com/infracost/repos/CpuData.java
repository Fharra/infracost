package com.infracost.repos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CpuData {
    @Id
    Long id;
    String cpusInNode;
    String cpusPercentageUsed;
    String cpusUsed;
    String application;

    public CpuData() {
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public CpuData(Long id, String cpusInNode, String cpusPercentageUsed, String cpusUsed, String application) {
        this.id = id;
        this.cpusInNode = cpusInNode;
        this.cpusPercentageUsed = cpusPercentageUsed;
        this.cpusUsed = cpusUsed;
        this.application = application;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpusInNode() {
        return cpusInNode;
    }

    public void setCpusInNode(String cpusInNode) {
        this.cpusInNode = cpusInNode;
    }

    public String getCpusPercentageUsed() {
        return cpusPercentageUsed;
    }

    public void setCpusPercentageUsed(String cpusPercentageUsed) {
        this.cpusPercentageUsed = cpusPercentageUsed;
    }

    public String getCpusUsed() {
        return cpusUsed;
    }

    public void setCpusUsed(String cpusUsed) {
        this.cpusUsed = cpusUsed;
    }
}
