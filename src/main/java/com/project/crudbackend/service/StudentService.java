package com.project.crudbackend.service;

import com.project.crudbackend.dtos.*;
import com.project.crudbackend.entity.Student;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentResponse> getAllStudents();

    Student getStudentById(Long id) throws RuntimeException;

    CreateStudentResponse createStudent(@Valid CreateStudentRequest request);

    UpdateStudentResponse updateStudent(@Valid Long id, UpdateStudentRequest request);

    void deleteStudent(@Valid Long id);
}
