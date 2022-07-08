package edu.miu.cs.cs425.eregistar.service.impl;

import edu.miu.cs.cs425.eregistar.Repository.StudentRepository;
import edu.miu.cs.cs425.eregistar.model.Student;
import edu.miu.cs.cs425.eregistar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.repository = studentRepository;
//    }

    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public List<Student> findByFirstNameContainingIgnoreCase(String name){
        List<Student> founList = repository.findByFirstNameContainingIgnoreCase(name);
        System.out.println("fond list -------------");
        System.out.println(founList);
        return repository.findByFirstNameContainingIgnoreCase(name);
    }

}
