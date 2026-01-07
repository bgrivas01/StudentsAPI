package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService; //this initilizes the studentService so it actually works and is usable
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    } 
    
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentUpdateRequest request) {
        return studentService.updateStudent(id, request);
    }
    

}