package com.First_Spring_Project_0323.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    private Integer id;
    private String name;
    @JsonProperty("job_title")
    private String jobTitle;

    public Employee(Integer id, String name, String jobTitle) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
