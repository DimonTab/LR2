package com.dimon.services;

import com.dimon.domain.Student;
import com.dimon.domain.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    private StudentRepository repository;

    @Autowired
    public ApplicationServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

//    @Override
    public List<Student> outputDuplicateStudents() {
        final List<Student> list = repository.getAllStudents();
        List<Student> sameStudents = new ArrayList<Student>();
        for (Student student : list) {
            if (Collections.frequency(list, student) > 1) {
                if (!sameStudents.contains(student))
                    sameStudents.add(student);
            }
        }
        return sameStudents;
    }

//    @Override
    public void create100RandomStudents() {
        Student student = new Student();
        for (int count = 0; count < 90; count++) {
            student.setId(count);
            student.setName("Name#" + count);
            student.setSurname("Surname#" + count);
            student.setPhone("093 000 00" + count);
            student.setEmail("name.surname" + count + "@gmail.com");
            student.setCourse(count);
            repository.addStudent(student);
        }

        for (int count = 0; count < 10; count++) {
            student.setId(count);
            student.setName("Name#" + count);
            student.setSurname("Surname#" + count);
            student.setPhone("093 000 00" + count);
            student.setEmail("name.surname" + count + "@gmail.com");
            student.setCourse(count);
            repository.addStudent(student);
        }
    }
}
