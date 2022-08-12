package com.example.employee.service.impl;

import com.example.employee.domain.Employee;
import com.example.employee.persistence.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByState(State state) {
        return employeeRepository.getEmployeeByAddress_State(state);
    }


}
