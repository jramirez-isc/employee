package com.example.employee.service.impl;

import com.example.employee.domain.Change;
import com.example.employee.domain.Email;
import com.example.employee.domain.Employee;
import com.example.employee.exception.NotFoundException;
import com.example.employee.persistence.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.web.schema.EmailType;
import com.example.employee.web.schema.EmployeeDetailsDTO;
import com.example.employee.web.schema.State;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper;

    private final TypeReference<HashMap<String, Object>> typeReference;

    //private final EmployeeHistoryRepository historyRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ObjectMapper objectMapper,TypeReference typeReference){
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
        this.typeReference = typeReference;
        //this.historyRepository = historyRepository;
    }

    @Override
    public EmployeeDetailsDTO createEmployee(Employee employee) {
       return Employee.from(employeeRepository.save(employee));
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
        String message = "";
        String finalChange = "";
        Employee existingEmployee = findAll().get(0);

        Change existingData = new Change(existingEmployee.getDesignation(), existingEmployee.getSalary());
        employee.setId(existingEmployee.getId());
        existingEmployee.setEmployeeId(employee.getEmployeeId());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setSalary(employee.getSalary());
        //existingEmployee.setEmail(employee.getEmail());
        existingEmployee.getEmail().clear();
        existingEmployee.getEmail().addAll(employee.getEmail());

        existingEmployee.getEmail().forEach(email -> email.setEmployee(existingEmployee));
        existingEmployee.getAddress().setEmployee(existingEmployee);

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        Change updatedData = new Change(updatedEmployee.getDesignation(), updatedEmployee.getSalary());
        Map<String, Object> finalChangeMap = new HashMap<>();
        try {
            finalChangeMap.put("new", Change.jsonTransformation(objectMapper, typeReference, updatedData));
            finalChangeMap.put("old", Change.jsonTransformation(objectMapper, typeReference, existingData));
            finalChange = objectMapper.writeValueAsString(finalChangeMap);
        } catch (JsonProcessingException jsonProcessingException){
            message = jsonProcessingException.getMessage();
        }

        //addEmployeeHistory(finalChangeMap);

        return updatedEmployee;
    }

    @Override
    public List<Employee> getEmployees(List<UUID> employeeIds) {
        return employeeRepository.getEmployeeByEmployeeIdIn(employeeIds);
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
