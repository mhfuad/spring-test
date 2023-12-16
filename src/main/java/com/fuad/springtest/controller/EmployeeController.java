package com.fuad.springtest.controller;

import com.fuad.springtest.model.Department;
import com.fuad.springtest.model.Employee;
import com.fuad.springtest.repository.DepartmentRepository;
import com.fuad.springtest.repository.EmployeeRepository;
import com.fuad.springtest.request.EmployeeRequest;
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
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository repository;

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
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeRequest employee){
        Department dep = new Department();
        dep.setName(employee.getDepartment().toString());
        departmentRepository.save(dep);

        Employee employee1 = new Employee(employee);
        employee1.setDepartment(dep);

        return ResponseEntity.ok(service.saveEmployee(employee1));
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

    @GetMapping("/employees/{name}/{location}")
    public ResponseEntity<?> getEmployeesByNameKey(@PathVariable String name, @PathVariable String location){
        return ResponseEntity.ok(service.getEmployeeByNameOrLocation(name,location));
    }

    @DeleteMapping("/employees/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return ResponseEntity.ok(service.deleteEmployeeByName(name)+ " No. of row deleted");
    }

    @GetMapping("/employeesByDep/{department}")
    public ResponseEntity<?> byDepartment(@PathVariable String department){
        //return ResponseEntity.ok(repository.findByDepartmentName(department));
        return ResponseEntity.ok(repository.getEmployeeByDeptName(department));
    }
}
