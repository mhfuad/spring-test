package com.fuad.springtest.service;

import com.fuad.springtest.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Employee getById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmploye(Employee employee);
}
