package com.fuad.springtest.service;

import com.fuad.springtest.model.Student;
import com.fuad.springtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;
    @Override
    public List<Student> studentWhereIn(List<Long> ids) {
        return repository.studentByAllId(ids);
    }

}
