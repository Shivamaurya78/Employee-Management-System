package com.example.employeeapi.Mapper;

import com.example.employeeapi.Dto.EmployeeDto;
import com.example.employeeapi.Entity.Employee;

public class EmployeeMapper {
    //conver Dto -> Entity
    public static Employee toEntity(EmployeeDto dto)
    {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return emp;
    }

    //convert Entity -> Dto
    public static EmployeeDto toDto(Employee emp)
    {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(emp.getName());
        dto.setDepartment(emp.getDepartment());
        dto.setSalary(emp.getSalary());
        return dto;
    }
}
