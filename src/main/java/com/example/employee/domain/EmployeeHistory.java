package com.example.employee.domain;

import java.time.ZonedDateTime;

public class EmployeeHistory {

    public String before;

    public String after;

    public ZonedDateTime timeStamp;

    public EmployeeHistory(String before, String after, ZonedDateTime timeStamp) {
        this.before = before;
        this.after = after;
        this.timeStamp = timeStamp;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
