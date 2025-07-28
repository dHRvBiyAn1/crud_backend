package com.project.crudbackend.service;

import com.project.crudbackend.entity.Student;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id) throws RuntimeException;

    Student createStudent(@Valid Student student);

    Student updateStudent(@Valid Long id, Student student);

    void deleteStudent(@Valid Long id);
}
