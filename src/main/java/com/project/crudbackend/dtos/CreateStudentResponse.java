package com.project.crudbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateStudentResponse {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
