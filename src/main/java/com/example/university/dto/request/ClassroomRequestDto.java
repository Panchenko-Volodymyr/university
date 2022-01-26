package com.example.university.dto.request;

import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
public class ClassroomRequestDto {
    @NotNull
    private String nameOfClassroom;
}
