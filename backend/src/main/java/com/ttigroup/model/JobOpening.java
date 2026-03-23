package com.ttigroup.model;

public class JobOpening {
    private Long id;
    private String title;
    private String department;
    private String location;
    private String description;
    private String type;

    public JobOpening() {}

    public JobOpening(Long id, String title, String department, String location, String description, String type) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.location = location;
        this.description = description;
        this.type = type;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
