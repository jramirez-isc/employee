package com.example.employee.domain;

import com.example.employee.web.schema.EmailDTO;
import com.example.employee.web.schema.EmailType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailAddress;

    private EmailType emailType;

    public Email(String emailAddress, EmailType emailType) {
        this.emailAddress = emailAddress;
        this.emailType = emailType;
    }

    public Email() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public Long getId() {
        return id;
    }
}
