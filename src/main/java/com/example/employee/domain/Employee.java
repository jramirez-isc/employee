package com.example.employee.domain;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String gender;

    /*@OneToMany
    private List<Email> email;

    @OneToOne
    private Address address;*/

    public Employee(String phone, String gender) {
        this.phone = phone;
        this.gender = gender;
        /*this.email = CollectionUtils.isEmpty(email) ? new ArrayList<>() : email;
        this.address = address;*/
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
