package com.example.employee.domain;

import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    private String phone;
    private String gender;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employee")
    private List<Email> email;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Address address;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Name name;

    public Employee(String phone, String gender, Address address, Name name, List<Email> email) {
        this.phone = phone;
        this.gender = gender;
        this.email = CollectionUtils.isEmpty(email) ? new ArrayList<>() : email;
        this.address = address;
        this.name = name;
    }

    public Employee() {
        this.email = new ArrayList<>();
    }


    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
