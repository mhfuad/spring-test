package com.fuad.springtest.service;

import com.fuad.springtest.model.Employee;

import java.util.List;
import java.util.SimpleTimeZone;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Employee getById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmploye(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByNameKeyword(String name);

    List<Employee> getEmployeeByNameOrLocation(String name, String location);

    Integer deleteEmployeeByName(String name);
}
