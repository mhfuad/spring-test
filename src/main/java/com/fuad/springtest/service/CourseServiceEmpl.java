package com.fuad.springtest.service;

import com.fuad.springtest.model.Course;
import com.fuad.springtest.model.Student;
import com.fuad.springtest.model.Teacher;
import com.fuad.springtest.repository.CourseRepository;
import com.fuad.springtest.repository.StudentRepository;
import com.fuad.springtest.repository.TeacherRepository;
import com.fuad.springtest.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseServiceEmpl implements CourseService{

    @Autowired
    private CourseRepository repository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Course saveCourse(CourseRequest request) {
        if (request.getTeacher() == null && request.getStudents() == null){
            Course course = Course.builder()
                    .title(request.getTitle())
                    .credit(request.getCredit())
                    .build();
            return repository.save(course);
        }else if(request.getStudents() == null){
            Teacher teacher = teacherRepository.findById(request.getTeacher()).orElseThrow(null);
            Course course = Course.builder()
                    .title(request.getTitle())
                    .credit(request.getCredit())
                    .teacher(teacher)
                    .build();
            return repository.save(course);
        }else{
            //studentRepository.findByIdIn(Collection<Integer> request.getStudents())
            return null;
        }
    }
}
