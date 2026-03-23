package com.ttigroup.model;

import java.util.List;

public class CompanyInfo {
    private String name;
    private String description;
    private String history;
    private String vision;
    private String mission;
    private List<Leader> leadership;
    private Statistics statistics;

    public CompanyInfo() {}

    public CompanyInfo(String name, String description, String history, String vision, String mission, List<Leader> leadership, Statistics statistics) {
        this.name = name;
        this.description = description;
        this.history = history;
        this.vision = vision;
        this.mission = mission;
        this.leadership = leadership;
        this.statistics = statistics;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getHistory() { return history; }
    public void setHistory(String history) { this.history = history; }
    public String getVision() { return vision; }
    public void setVision(String vision) { this.vision = vision; }
    public String getMission() { return mission; }
    public void setMission(String mission) { this.mission = mission; }
    public List<Leader> getLeadership() { return leadership; }
    public void setLeadership(List<Leader> leadership) { this.leadership = leadership; }
    public Statistics getStatistics() { return statistics; }
    public void setStatistics(Statistics statistics) { this.statistics = statistics; }
}
