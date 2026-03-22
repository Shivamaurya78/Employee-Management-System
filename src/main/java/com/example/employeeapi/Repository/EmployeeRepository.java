package com.example.employeeapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeapi.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
