package com.example.employee.web;

import com.example.employee.domain.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.EmployeeDetailsDTO;
import com.example.employee.web.schema.EmployeeDetailsPatchRequestDTO;
import com.example.employee.web.schema.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
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

    @GetMapping(headers = "Employee-ids")
    public ResponseEntity<List<EmployeeDetailsDTO>> getEmployeeDetails(@RequestHeader(value = "Employee-ids", defaultValue = "")List<UUID> employeeIds){
            return new ResponseEntity<>(getEmployees(employeeIds)
                    .stream().map(Employee::from)
                    .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(params = {"state"})
    public ResponseEntity<List<EmployeeDetailsDTO>> getEmployeesByState(@RequestParam(name = "state", defaultValue = "") String state ){
        return new ResponseEntity<>(employeeService.findByState(State.valueOf(state)).stream()
                .map(Employee::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(params = {"designation"})
    public ResponseEntity<List<EmployeeDetailsDTO>> getEmployeesByDesignation(@RequestParam(name = "designation", defaultValue = "") String designation){
        return new ResponseEntity<>(employeeService.findByDesignation(designation).stream()
                .map(Employee::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateEmployeeDetails(@RequestHeader("Employee-id") UUID employeeId, @RequestBody EmployeeDetailsPatchRequestDTO employeeDetailspatchDTO){
        Employee employee = employeeService.updateEmployee(EmployeeDetailsPatchRequestDTO.to(employeeId, employeeDetailspatchDTO));
        return employee!=null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    private List<Employee> getEmployees(List<UUID> employeeIds){
        return !CollectionUtils.isEmpty(employeeIds) ? employeeService.getEmployees(employeeIds) : employeeService.findAll();

    }

}
