package com.example.employee.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class EmployeeHistory {

    @Id
    private Long id;

    @JsonProperty("old")
    public String before;

    @JsonProperty("new")
    public String after;

    public ZonedDateTime timeStamp;

    public EmployeeHistory(String before, String after, ZonedDateTime timeStamp) {
        this.before = before;
        this.after = after;
        this.timeStamp = timeStamp;
    }

    public EmployeeHistory(){}

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
