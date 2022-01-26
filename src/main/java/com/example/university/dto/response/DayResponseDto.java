package com.example.university.dto.response;

import com.example.university.model.Day;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayResponseDto {
    private Long id;
    private Day.DayOfWeek dayOfWeek;
}
