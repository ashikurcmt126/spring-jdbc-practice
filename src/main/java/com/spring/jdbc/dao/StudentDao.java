package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int studentId);

    //We are going to get single object.
    public Student getStudent(int studentId);

    //We are going get multiple object.
    public List<Student> getAllStudents();
}
