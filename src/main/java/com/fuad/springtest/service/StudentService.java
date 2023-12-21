package com.fuad.springtest.service;

import com.fuad.springtest.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    List<Student> studentWhereIn(List<Long> ids);
}
