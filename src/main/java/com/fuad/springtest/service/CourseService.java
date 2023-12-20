package com.fuad.springtest.service;

import com.fuad.springtest.model.Course;
import com.fuad.springtest.request.CourseRequest;

public interface CourseService {
    Course saveCourse(CourseRequest request);
}
