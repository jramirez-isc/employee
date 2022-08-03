package com.example.employee.domain;

public class Name {

    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name() {
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
