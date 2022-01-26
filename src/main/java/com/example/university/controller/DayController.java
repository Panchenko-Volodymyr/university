package com.example.university.controller;

import com.example.university.dto.request.DayRequestsDto;
import com.example.university.dto.response.DayResponseDto;
import com.example.university.model.Day;
import com.example.university.service.DayService;
import com.example.university.service.mapper.DayMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/days")
public class DayController {
    private final DayService dayService;
    private final DayMapper dayMapper;

    public DayController(DayService dayService, DayMapper dayMapper) {
        this.dayService = dayService;
        this.dayMapper = dayMapper;
    }

    @GetMapping
    public List<DayResponseDto> getAll() {
        return dayService.getAll()
                .stream()
                .map(dayMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DayResponseDto getById(@PathVariable Long id) {
        return dayMapper.mapToDto(dayService.getById(id));
    }

    @PostMapping
    public DayResponseDto add(@RequestBody DayRequestsDto dayRequestsDto) {
        Day day = dayMapper.mapToModel(dayRequestsDto);
        dayService.save(day);
        return dayMapper.mapToDto(day);
    }

    @PutMapping("/{id}")
    public DayResponseDto update(@PathVariable Long id,
                                 @RequestBody DayRequestsDto dayRequestsDto) {
        Day day = dayMapper.mapToModel(dayRequestsDto);
        dayService.update(day);
        return dayMapper.mapToDto(day);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dayService.delete(id);
    }
}
