package com.example.employee.domain;

import com.example.employee.web.schema.EmailDTO;
import org.springframework.util.CollectionUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phone;
    private String gender;

    @OneToMany
    private List<Email> email;

    @OneToOne
    private Address address;

    public Employee(String phone, String gender, List<Email> email, Address address) {
        this.phone = phone;
        this.gender = gender;
        this.email = CollectionUtils.isEmpty(email) ? new ArrayList<>() : email;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public List<Email> getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String phone;
        private String gender;
        private List<Email> email;
        private Address address;

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setEmail(List<Email> email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Employee build(){
            return new Employee(this.phone, this.gender, this.email, this.address);
        }
    }
}
