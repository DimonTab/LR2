package com.dimon.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceUnit(name = "manager")
    private EntityManager manager;

//    @Override
    public long addStudent(Student student) {
        manager.persist(student);
        return student.getId();
    }

//    @Override
    public void removeStudent(Student student) {
        student = manager.getReference(Student.class, student.getId());
        manager.remove(student);
    }

//    @Override
    public List<Student> getAllStudents() {
        return manager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

//    @Override
    public void removeAllStudents() {
        manager.createNamedQuery("Student.dropAll", Student.class).executeUpdate();
    }

}
