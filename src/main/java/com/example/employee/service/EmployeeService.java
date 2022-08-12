package com.example.employee.service;

import com.example.employee.domain.Employee;
import com.example.employee.web.schema.State;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    List<Employee> findByState(State state);

}
