package com.example.employee.web.schema;

import com.example.employee.domain.Email;
import com.example.employee.domain.Employee;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetailsDTO {

    private final NameDTO names;

    private final String gender;

    private final List<EmailDTO> emailDTO;

    private final AddressDTO address;

    private final String phoneNumber;

    private EmployeeDetailsDTO(NameDTO names, String gender, List<EmailDTO> emailDTO, AddressDTO address, String phoneNumber) {
        this.names = names;
        this.gender = gender;
        this.emailDTO = CollectionUtils.isEmpty(emailDTO) ? new ArrayList<>() : emailDTO;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public NameDTO getNames() {
        return names;
    }

    public String getGender() {
        return gender;
    }

    public List<EmailDTO> getEmailDTO() {
        return emailDTO;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Builder builder(){
        return new Builder();
    }

    public Employee to(EmployeeDetailsDTO employeeDetailsDTO){
        List<Email> emailList = Collections.emptyList();
        if(!employeeDetailsDTO.getEmailDTO().isEmpty()){
            emailList = employeeDetailsDTO.getEmailDTO().stream().map(EmailDTO::to).collect(Collectors.toList());
        }

        return Employee.builder().setPhone(this.phoneNumber).setGender(this.gender).setEmail(emailList).setAddress(AddressDTO.to(this.getAddress())).build();
    }

    public static class Builder {

        private NameDTO names;

        private String gender;

        private List<EmailDTO> emailDTO;

        private AddressDTO address;

        private String phoneNumber;

        public Builder setNames(NameDTO names) {
            this.names = names;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setEmailDTO(List<EmailDTO> emailDTO) {
            this.emailDTO = emailDTO;
            return this;
        }

        public Builder setAddress(AddressDTO address) {
            this.address = address;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public EmployeeDetailsDTO build(){
            return new EmployeeDetailsDTO(this.names, this.gender, this.emailDTO, this.address, this.phoneNumber);
        }
    }
}