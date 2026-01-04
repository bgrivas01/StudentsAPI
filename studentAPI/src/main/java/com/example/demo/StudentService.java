package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    private final List<Student> students = new ArrayList<>();

    public StudentService(StudentRepository studentRepo){
        this.studentRepo = studentRepo;

    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

}
