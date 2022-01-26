package com.example.university.dto.response;


import com.example.university.model.Classroom;
import com.example.university.model.Day;
import com.example.university.model.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponseDto {
    private Long id;
    private String groupName;
    private Day day;
    private Subject subjects;
    private Classroom classroom;
}
