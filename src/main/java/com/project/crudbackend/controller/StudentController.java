package com.project.crudbackend.controller;

import com.project.crudbackend.dtos.*;
import com.project.crudbackend.entity.Student;
import com.project.crudbackend.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(@Valid @RequestBody CreateStudentRequest request){
        return new ResponseEntity<>(studentService.createStudent(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponse> updateStudent(@Valid @PathVariable Long id, @RequestBody UpdateStudentRequest request){
        return new ResponseEntity<>(studentService.updateStudent(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@Valid @PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
