package com.example.university.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassroomResponseDto {
    private Long id;
    private String nameOfClassroom;

    public ClassroomResponseDto(Long id, String nameOfClassroom) {
        this.id = id;
        this.nameOfClassroom = nameOfClassroom;
    }
}
