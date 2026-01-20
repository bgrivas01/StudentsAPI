package com.example.demo;

public class StudentMapper {
    public static StudentResponse toResponse(Student student) {
        return new StudentResponse(
            student.getId(),
            student.getName(), 
            student.getEmail()
        );
    }
}
