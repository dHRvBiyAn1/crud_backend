package com.project.crudbackend.service;

import com.project.crudbackend.dtos.CreateStudentRequest;
import com.project.crudbackend.dtos.CreateStudentResponse;
import com.project.crudbackend.dtos.UpdateStudentRequest;
import com.project.crudbackend.dtos.UpdateStudentResponse;
import com.project.crudbackend.dtos.StudentResponse;
import com.project.crudbackend.entity.Student;
import com.project.crudbackend.exception.EmailAlreadyExistsException;
import com.project.crudbackend.exception.StudentNotFoundException;
import com.project.crudbackend.exception.UsernameAlreadyExistsException;
import com.project.crudbackend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> StudentResponse.builder()
                        .firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .username(student.getUsername())
                        .email(student.getEmail())
                        .createdAt(student.getCreatedAt().toString())
                        .updatedAt(student.getUpdatedAt().toString())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public CreateStudentResponse createStudent(CreateStudentRequest request) {
        if (studentRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        if (studentRepository.findByEmail(request.getUsername()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        Student savedStudent = studentRepository.save(student);

        return CreateStudentResponse.builder()
                .username(savedStudent.getUsername())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .build();
    }

    @Override
    public UpdateStudentResponse updateStudent(Long id, UpdateStudentRequest request) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

        existingStudent.setFirstName(request.getFirstName());
        existingStudent.setLastName(request.getLastName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setUsername(request.getUsername());

        Student updatedStudent = studentRepository.save(existingStudent);

        return UpdateStudentResponse.builder()
                .username(updatedStudent.getUsername())
                .firstName(updatedStudent.getFirstName())
                .lastName(updatedStudent.getLastName())
                .email(updatedStudent.getEmail())
                .createdAt(updatedStudent.getCreatedAt().toString())
                .updatedAt(updatedStudent.getUpdatedAt().toString())
                .build();
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}
