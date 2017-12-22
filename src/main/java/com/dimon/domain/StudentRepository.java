package com.dimon.domain;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository {

    long addStudent(Student student);

//    Student getStudent(int id);

    List<Student> getAllStudents();

    void removeAllStudents();

}
