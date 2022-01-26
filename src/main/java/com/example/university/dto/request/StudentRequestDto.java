package com.example.university.dto.request;

import com.example.university.model.Group;
import lombok.Getter;

@Getter
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private Group group;
}
