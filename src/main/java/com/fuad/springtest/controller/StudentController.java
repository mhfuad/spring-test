package com.fuad.springtest.controller;

import com.fuad.springtest.model.Student;
import com.fuad.springtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public Student save(@RequestBody Student student){
        return repository.save(student);
    }
}
