package edu.miu.cs.cs425.eregistar.service;

import edu.miu.cs.cs425.eregistar.model.Student;

import java.util.List;

public interface StudentService {

    Iterable<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Integer bookId);
    void deleteStudentById(Integer bookId);
    List<Student> findByFirstNameContainingIgnoreCase(String name);


}
