package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ApiRequestException;

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

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    public void deleteStudentById(Long id){
        studentRepo.deleteById(id);
    }

    public Student updateStudent(Long id, StudentUpdateRequest request) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new ApiRequestException("Student not found"));

            student.setName(request.getName());
            student.setEmail(request.getEmail());

            return studentRepo.save(student);
    }
}
