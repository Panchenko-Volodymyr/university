package com.example.university.dto.response;

import com.example.university.model.Schedule;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class GroupResponseDto {
    private Long id;
    private String groupName;
    private List<Schedule> schedules;
}
