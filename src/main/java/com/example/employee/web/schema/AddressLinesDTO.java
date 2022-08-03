package com.example.employee.web.schema;

public class AddressLinesDTO {

    private final String exterior;

    private final String interior;

    private final String street;

    private AddressLinesDTO(String exterior, String interior, String street) {
        this.exterior = exterior;
        this.interior = interior;
        this.street = street;
    }

    public String getExterior() {
        return exterior;
    }

    public String getInterior() {
        return interior;
    }

    public String getStreet() {
        return street;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String exterior;

        private String interior;

        private String street;

        public Builder setExterior(String exterior) {
            this.exterior = exterior;
            return this;
        }

        public Builder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressLinesDTO build(){
            return new AddressLinesDTO(this.exterior, this.interior, this.street);
        }
    }
}
