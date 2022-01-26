package com.example.university.service.mapper;

import com.example.university.dto.request.ScheduleRequestDto;
import com.example.university.dto.response.ScheduleResponseDto;
import com.example.university.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper implements ResponseDtoMapper<ScheduleResponseDto, Schedule>,
        RequestDtoMapper<ScheduleRequestDto, Schedule> {
    @Override
    public ScheduleResponseDto mapToDto(Schedule schedule) {
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setDay(schedule.getDay());
        scheduleResponseDto.setId(schedule.getId());
        scheduleResponseDto.setGroupName(schedule.getGroup().getGroupName());
        scheduleResponseDto.setSubjects(schedule.getSubjects());
        scheduleResponseDto.setClassroom(schedule.getClassroom());
        return scheduleResponseDto;
    }

    @Override
    public Schedule mapToModel(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule();
        schedule.setDay(scheduleRequestDto.getDay());
        schedule.setSubjects(scheduleRequestDto.getSubjects());
        schedule.setGroup(scheduleRequestDto.getGroup());
        schedule.setClassroom(scheduleRequestDto.getClassroom());
        return schedule;
    }
}
