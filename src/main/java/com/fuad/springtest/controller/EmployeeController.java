package com.fuad.springtest.controller;

import com.fuad.springtest.model.Employee;
import com.fuad.springtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(service.saveEmployee(employee).getId());
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok(service.updateEmploye(employee));
    }

    @DeleteMapping("/employees")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") Long id){
        service.deleteEmployee(id);
        return ResponseEntity.ok("delete success");
    }

    @GetMapping("/employees/findByName")
    public ResponseEntity<?> getEmplByName(@RequestParam String name){
        return ResponseEntity.ok(service.getEmployeesByName(name));
    }

    @GetMapping("/employees/findByNameAndLocation")
    public ResponseEntity<?> getEmplByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return ResponseEntity.ok(service.getEmployeesByNameAndLocation(name, location));
    }

    @GetMapping("/employees/findByNameKey")
    public ResponseEntity<?> getEmplByNameKey(@RequestParam String name){
        return ResponseEntity.ok(service.getEmployeesByNameKeyword(name));
    }
}
