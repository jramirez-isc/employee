package com.example.employee.web;

import com.example.employee.domain.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.EmployeeDetailsDTO;
import com.example.employee.web.schema.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees/admin/employee")
public class EmployeeAdminController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDetailsDTO> createEmployee(@Valid @RequestBody EmployeeDetailsDTO employeeDetailsDTO){
        employeeService.createEmployee(EmployeeDetailsDTO.to(employeeDetailsDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDetailsDTO>> getEmployeeByState(@RequestParam String state ){
        return new ResponseEntity<>(employeeService.findByState(State.DF).stream()
                .map(Employee::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
