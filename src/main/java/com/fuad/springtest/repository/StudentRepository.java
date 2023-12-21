package com.fuad.springtest.repository;

import com.fuad.springtest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("FROM Student WHERE id IN :ids")
    List<Student> studentByAllId(List<Long> ids);

}
