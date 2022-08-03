package com.example.employee.persistence;

import com.example.employee.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public Employee save(Employee employee);
}
