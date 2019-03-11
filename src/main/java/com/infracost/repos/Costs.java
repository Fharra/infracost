package com.infracost.repos;

import javax.persistence.*;

@Entity
public class Costs {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String monthlyMaintenanceCost;
    @Column
    private String costByAllCpusInNode;


    public Costs() {}

    public Costs(String monthlyMaintenanceCost, String costByAllCpusInNode) {
        this.monthlyMaintenanceCost = monthlyMaintenanceCost;
        this.costByAllCpusInNode = costByAllCpusInNode;
    }

    public String getMonthlyMaintenanceCost() {
        return monthlyMaintenanceCost;
    }

    public void setMonthlyMaintenanceCost(String monthlyMaintenanceCost) {
        this.monthlyMaintenanceCost = monthlyMaintenanceCost;
    }

    public String getCostByAllCpusInNode() {
        return costByAllCpusInNode;
    }

    public void setCostByAllCpusInNode(String costByAllCpusInNode) {
        this.costByAllCpusInNode = costByAllCpusInNode;
    }
}
