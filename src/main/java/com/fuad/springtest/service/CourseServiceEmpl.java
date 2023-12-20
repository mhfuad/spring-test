package com.fuad.springtest.service;

import com.fuad.springtest.model.Course;
import com.fuad.springtest.model.Teacher;
import com.fuad.springtest.repository.CourseRepository;
import com.fuad.springtest.repository.TeacherRepository;
import com.fuad.springtest.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceEmpl implements CourseService{

    @Autowired
    private CourseRepository repository;
    @Autowired
    private TeacherRepository teacherRepository;
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
            //return null;
        }else{
            return null;
        }
    }
}
