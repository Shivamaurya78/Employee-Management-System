package com.example.employeeapi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeapi.Entity.Employee;
import com.example.employeeapi.Exception.ResourceNotFoundException;
import com.example.employeeapi.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo)
    {
        this.repo = repo;
    }

    public Employee save(Employee emp)
    {
        return repo.save(emp);
    }

    public Employee getById(Long id )
    {
        return repo.findById(id).orElseThrow(() ->
         new ResourceNotFoundException("Employee not found with id " + id));
    }
    
    @Transactional
    public Employee update(Long id, Employee emp)
    {
        Employee existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(emp.getName());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());

        return repo.save(existing);
    }
    public void delete (Long id)
    {
        Employee emp = getById(id);
        repo.delete(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    
}
