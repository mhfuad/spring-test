package com.fuad.springtest.controller;

import com.fuad.springtest.model.Section;
import com.fuad.springtest.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {
    @Autowired
    private SectionRepository repository;

    @PostMapping("/section")
    public ResponseEntity<?> saveSection(@RequestBody Section section){
        return ResponseEntity.ok(section);
        //section.getEmployee()
        //repository.save(section);
    }
}
