package com.fuad.springtest.controller;

import com.fuad.springtest.dto.StudentIdDto;
import com.fuad.springtest.model.Student;
import com.fuad.springtest.repository.StudentRepository;
import com.fuad.springtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentService service;

    @PostMapping
    public Student save(@RequestBody Student student){
        return repository.save(student);
    }

    @PostMapping("/all")
    public List<Student> studentList(@RequestBody StudentIdDto students){
        //System.out.println(ids);
        return service.studentWhereIn(students.getStudents());
    }
}
