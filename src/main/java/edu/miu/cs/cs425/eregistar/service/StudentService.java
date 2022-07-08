package edu.miu.cs.cs425.eregistar.service;

import edu.miu.cs.cs425.eregistar.model.Student;

import java.util.List;

public interface StudentService {

    abstract Iterable<Student> getAllStudents();
    abstract Student saveStudent(Student student);
    abstract Student getStudentById(Integer bookId);
    abstract void deleteStudentById(Integer bookId);
    List<Student> findByFirstNameContainingIgnoreCase(String name);


}
