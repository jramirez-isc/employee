package com.example.employee.service;

import com.example.employee.domain.EmployeeHistory;
import com.example.employee.web.schema.EmployeeDetailsDTO;

public interface HistoryService {

    void saveEmployeeHistory(EmployeeHistory employeeHistory);
}
