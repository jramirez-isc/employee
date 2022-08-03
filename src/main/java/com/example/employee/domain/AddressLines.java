package com.example.employee.domain;

import javax.persistence.Embeddable;

@Embeddable
public class AddressLines {

    private String exterior;

    private String interior;

    private String street;

    public AddressLines(String exterior, String interior, String street) {
        this.exterior = exterior;
        this.interior = interior;
        this.street = street;
    }

    public AddressLines() {
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
