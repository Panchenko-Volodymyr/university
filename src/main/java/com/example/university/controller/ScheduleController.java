package com.example.university.controller;

import com.example.university.dto.request.ScheduleRequestDto;
import com.example.university.dto.response.ScheduleResponseDto;
import com.example.university.model.Schedule;
import com.example.university.service.ScheduleService;
import com.example.university.service.mapper.ScheduleMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    public  ScheduleController(ScheduleService scheduleService,
                               ScheduleMapper scheduleMapper){
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @GetMapping("/by-student")
    public List<ScheduleResponseDto> getScheduleByStudentIdAndDayOfWeek(@RequestParam(name = "id") Long id,
                                                                    @RequestParam(name = "dayOfWeek") String dayOfWeek) {
        return scheduleService.getScheduleByStudentIdAndDayOfWeek(id, dayOfWeek)
                .stream()
                .map(scheduleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<ScheduleResponseDto> getAll() {
        return scheduleService.getAll()
                .stream()
                .map(scheduleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto getById(@PathVariable Long id) {
        return scheduleMapper.mapToDto(scheduleService.getById(id));
    }

    @PostMapping
    public ScheduleResponseDto add(@RequestBody @Valid ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleMapper.mapToModel(scheduleRequestDto);
        scheduleService.save(schedule);
        return scheduleMapper.mapToDto(schedule);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto update(@PathVariable Long id,
                                     @RequestBody ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleMapper.mapToModel(scheduleRequestDto);
        schedule.setId(id);
        scheduleService.update(schedule);
        return scheduleMapper.mapToDto(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
