package com.fuad.springtest.request;

import com.fuad.springtest.model.Student;
import com.fuad.springtest.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseRequest {
    String title;
    Integer credit;
    Long teacher;
    List<Student> students;
}
