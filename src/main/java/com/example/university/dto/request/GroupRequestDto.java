package com.example.university.dto.request;

import com.example.university.model.Schedule;
import com.sun.istack.NotNull;
import lombok.Getter;
import java.util.List;

@Getter
public class GroupRequestDto {
    @NotNull
    private String groupName;
    @NotNull
    private List<Schedule> schedules;
}
