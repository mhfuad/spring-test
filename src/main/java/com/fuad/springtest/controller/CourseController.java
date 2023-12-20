package com.fuad.springtest.controller;

import com.fuad.springtest.repository.CourseRepository;
import com.fuad.springtest.request.CourseRequest;
import com.fuad.springtest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody CourseRequest request){
        return ResponseEntity.ok(service.saveCourse(request));
    }
}
