package com.example.university.dto.request;

import com.example.university.model.Classroom;
import com.example.university.model.Day;
import com.example.university.model.Group;
import com.example.university.model.Subject;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Group group;
    private Day day;
    private Subject subjects;
    private Classroom classroom;
}
