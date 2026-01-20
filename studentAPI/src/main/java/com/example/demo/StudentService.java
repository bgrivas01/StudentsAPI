package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public StudentResponse getStudentById(Long id){
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new ApiRequestException("Student with id of " + id + " not found"));
        return StudentMapper.toResponse(student);
    }

    public void deleteStudentById(Long id){
        studentRepo.deleteById(id);
    }

    public Student updateStudent(Long id, StudentUpdateRequest request){
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new ApiRequestException("Student not found"));

            student.setName(request.getName());
            student.setEmail(request.getEmail());

            return studentRepo.save(student);
    }

    public Student getStudentByEmail(String email){
        return studentRepo.findByEmail(email)
            .orElseThrow(() -> new ApiRequestException("Student with email " + email + " not found"));
    }

    public Student getStudentByName(String name){
        return studentRepo.findByName(name)
            .orElseThrow(() -> new ApiRequestException("Student with name " + name + " not found"));
    }

    //pagination--------------------------------------------------
     public Page<StudentResponse> getStudents(int page, int size, String sortBy){

        Pageable pageable = PageRequest.of(
            page, 
            size, 
            Sort.by(sortBy)
        );
        return studentRepo.findAll(pageable)
            .map(StudentMapper::toResponse);
    }
   
}


