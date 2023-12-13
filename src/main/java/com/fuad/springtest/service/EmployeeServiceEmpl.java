package com.fuad.springtest.service;

import com.fuad.springtest.model.Employee;
import com.fuad.springtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceEmpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;


    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee is not found.");
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee updateEmploye(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String key) {
        return repository.findByNameAndLocation(name, key);
    }

    @Override
    public List<Employee> getEmployeesByNameKeyword(String name) {
        return repository.findByNameContaining(name);
    }
}
