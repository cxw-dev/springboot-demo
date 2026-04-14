package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student theStudent);
    Student findById(int theId);
    List<Student> findAll();
    List<Student> findByFirstName(String theFirstName);
    void update(Student theStudent);
    void delete(int theId);
    int deleteAll();
}
