package com.project.crudbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
