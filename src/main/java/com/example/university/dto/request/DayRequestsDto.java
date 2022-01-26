package com.example.university.dto.request;

import com.example.university.model.Day;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DayRequestsDto {
    @NotNull
    private Day.DayOfWeek dayOfWeek;
}
