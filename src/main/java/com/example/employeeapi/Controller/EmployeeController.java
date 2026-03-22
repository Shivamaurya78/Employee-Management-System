package com.example.employeeapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeapi.Dto.EmployeeDto;
import com.example.employeeapi.Entity.Employee;
import com.example.employeeapi.Mapper.EmployeeMapper;
import com.example.employeeapi.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service)
    {
        this.service = service;
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto dto)
    {
          // DTO → Entity
    Employee emp = EmployeeMapper.toEntity(dto);

    // save
    Employee saved = service.save(emp);

    // Entity → DTO
    return EmployeeMapper.toDto(saved);
    }

    @GetMapping
    public List<Employee> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
public EmployeeDto getById(@PathVariable Long id) {
    Employee emp = service.getById(id);
    return EmployeeMapper.toDto(emp);
}


    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable Long id,
            @RequestBody EmployeeDto dto )
            {
         // DTO → Entity
    Employee emp = EmployeeMapper.toEntity(dto);

    // update
    Employee updated = service.update(id, emp);

    // Entity → DTO
    return EmployeeMapper.toDto(updated);
            }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id)
    {
        service.delete(id);
        return "Employee deleted successfully";
    }
}
