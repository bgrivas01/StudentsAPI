package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public StudentService(){
        students.add(new Student(1L, "Alice", 20));
        students.add(new Student(2L, "Brayan", 19));

    }

    public List<Student> getAllStudents(){
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
