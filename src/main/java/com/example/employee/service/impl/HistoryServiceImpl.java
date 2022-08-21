package com.example.employee.service.impl;

import com.example.employee.domain.EmployeeHistory;
import com.example.employee.persistence.EmployeeHistoryRepository;
import com.example.employee.persistence.EmployeeRepository;
import com.example.employee.service.HistoryService;
import com.example.employee.web.schema.EmployeeDetailsDTO;

public class HistoryServiceImpl implements HistoryService {

    private final EmployeeHistoryRepository employeeHistoryRepository;

    public HistoryServiceImpl(EmployeeHistoryRepository employeeHistoryRepository) {
        this.employeeHistoryRepository = employeeHistoryRepository;
    }

    @Override
    public void saveEmployeeHistory(EmployeeHistory employeeHistory) {
        employeeHistoryRepository.save(employeeHistory);
    }
}
