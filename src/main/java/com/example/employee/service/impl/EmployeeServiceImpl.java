package com.example.employee.service.impl;

import com.example.employee.domain.Employee;
import com.example.employee.exception.NotFoundException;
import com.example.employee.persistence.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.State;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper;

    private final TypeReference<HashMap<String, Object>> typeReference;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ObjectMapper objectMapper,TypeReference typeReference ){
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
        this.typeReference = typeReference;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByState(State state) {
        return employeeRepository.getEmployeeByAddress_State(state);
    }

    @Override
    public List<Employee> findByDesignation(String designation) {
        return employeeRepository.getEmployeeByDesignation(designation);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployee(employee.getEmployeeId());
        if(ObjectUtils.isEmpty(existingEmployee)){
            throw new NotFoundException("Employee not found but trying to update it - employeeId: " + employee.getEmployeeId());
        }
        Employee updatedEmployee = employeeRepository.save(employee);


        return updatedEmployee;
    }

    @Override
    public List<Employee> getEmployees(List<UUID> employeeIds) {
        return employeeRepository.findEmployeesByEmployeeIdIs(employeeIds);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(UUID employeeId) {
        return employeeRepository.findEmployeesByEmployeeId(employeeId);
    }


}
