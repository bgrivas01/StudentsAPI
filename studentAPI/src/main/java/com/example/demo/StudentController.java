package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;




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
    public Student getStudentById(@PathVariable Long id){
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

    @GetMapping("/students/paginated")
    public Page<Student> getStudents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        return studentService.getStudents(page, size, "name");
    }

    @GetMapping("/students/email")
    public Student getStudentByEmail(@RequestParam String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("students/name")
    public Student getStudentByName(@RequestParam String name){
        return studentService.getStudentByName(name);
    }
}