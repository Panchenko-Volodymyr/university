package com.example.university.dto.response;

import com.example.university.model.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Group group;
}
