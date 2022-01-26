package com.example.university.service.mapper;

import com.example.university.dto.request.DayRequestsDto;
import com.example.university.dto.response.DayResponseDto;
import com.example.university.model.Day;
import org.springframework.stereotype.Component;

@Component
public class DayMapper implements ResponseDtoMapper<DayResponseDto, Day>,
        RequestDtoMapper<DayRequestsDto, Day> {
    @Override
    public Day mapToModel(DayRequestsDto dayRequestsDto) {
        Day day = new Day();
        day.setDayOfWeek(dayRequestsDto.getDayOfWeek());
        return day;
    }

    @Override
    public DayResponseDto mapToDto(Day day) {
        DayResponseDto dayResponseDto = new DayResponseDto();
        dayResponseDto.setId(day.getId());
        dayResponseDto.setDayOfWeek(day.getDayOfWeek());
        return dayResponseDto;
    }
}
