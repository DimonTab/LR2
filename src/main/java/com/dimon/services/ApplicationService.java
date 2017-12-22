package com.dimon.services;

import com.dimon.domain.Student;

import java.util.List;

public interface ApplicationService {

    List<Student> outputDuplicateStudents();

    void create100RandomStudents();

}
