package com.example.employee.persistence;

import com.example.employee.domain.Employee;
import com.example.employee.domain.EmployeeHistory;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeHistoryRepository extends CrudRepository<Employee, Long> {

    EmployeeHistory save(EmployeeHistory employeeHistory);
}
