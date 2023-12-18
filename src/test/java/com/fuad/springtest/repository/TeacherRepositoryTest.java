package com.fuad.springtest.repository;

import com.fuad.springtest.model.Course;
import com.fuad.springtest.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Jaynul")
                .lastName("Abdin")
                //.courses(List.of(course,courseJava))
                .build();
        repository.save(teacher);

    }
}