package com.example.employee.domain;

import com.example.employee.web.schema.State;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    private String postalCode;

    @Embedded
    private AddressLines addressLines;

    public Address(String city, State state, String postalCode, AddressLines addressLines) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.addressLines = addressLines;
    }

    public Address(Long id, String city, State state, String postalCode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Address() {
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressLines getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(AddressLines addressLines) {
        this.addressLines = addressLines;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String city;

        private State state;

        private String postalCode;

        private AddressLines addressLines;

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(State state) {
            this.state = state;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setAddressLines(AddressLines addressLines) {
            this.addressLines = addressLines;
            return this;
        }

        public Address build(){
            return new Address(this.city, this.state, this.postalCode, this.addressLines);
        }
    }
}
