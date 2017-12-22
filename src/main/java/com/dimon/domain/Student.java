package com.dimon.domain;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.dropAll", query = "DELETE FROM Student")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int course;

    public Student() {
    }

    public Student(int id, String name, String surname, String phone, String email, int course ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.course = course;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return student.getName().equals(name) && student.getSurname().equals(surname);
    }
}
