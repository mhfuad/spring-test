package com.fuad.springtest.controller;

import com.fuad.springtest.model.Employee;
import com.fuad.springtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(service.getEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        URI uri = URI.create()
        return ResponseEntity.created(service.saveEmployee(employee).getId());
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return service.updateEmploye(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id){
        service.deleteEmployee(id);
    }


}
