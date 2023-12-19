package com.fuad.springtest.repository;

import com.fuad.springtest.model.Course;
import com.fuad.springtest.model.Student;
import com.fuad.springtest.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> courses = repository.findAll();
        System.out.println("courses = "+ courses);
    }

    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Fuad")
                .lastName("Biswas")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(7)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,2);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

        List<Course> courses = repository.findAll(secondPageWithThreeRecords).getContent();

        long totalElement = repository.findAll(firstPageWithThreeRecords).getTotalPages();

        long totalPages = repository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages = " + courses);
        System.out.println("totalElements = " + totalElement);
        System.out.println("courses = " + totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = repository.findAll(sortByTitle).getContent();

        System.out.println("sort corse" + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses = repository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Mahadi")
                .lastName("Hasan")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Ali")
                .lastName("hasan")
                .emailId("ali@inflack.com")
                .guardianName("ali baba")
                .guardianMobile("01675944076")
                .guardianEmail("ali_baba@gmail.com")
                .build();
        course.addStudents(student);

        repository.save(course);
    }
}