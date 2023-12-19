package com.fuad.springtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

//    @ManyToOne
//    @JoinTable(
//            name = "student_course_map",
//            joinColumns = @JoinColumn(
//                    name = "student_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "course_id",
//                    referencedColumnName = "id"
//            )
//    )
//    private List<Course> courses;
//
//    public void addCourse(Course course){
//        if (courses == null) courses = new ArrayList<>();
//        courses.add(course);
//    }

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public void addCourse(Course course){
        if (courses == null) courses = new ArrayList<>();
        courses.add(course);
    }
}
