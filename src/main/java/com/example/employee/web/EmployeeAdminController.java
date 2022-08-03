package com.example.employee.web;

import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.EmployeeDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees/admin/employee")
public class EmployeeAdminController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDetailsDTO> createEmployee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO){
        employeeService.createEmployee(employeeDetailsDTO.to(employeeDetailsDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
