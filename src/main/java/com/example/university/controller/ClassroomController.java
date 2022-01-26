package com.example.university.controller;

import com.example.university.dto.request.ClassroomRequestDto;
import com.example.university.dto.response.ClassroomResponseDto;
import com.example.university.model.Classroom;
import com.example.university.service.ClassroomService;
import com.example.university.service.mapper.ClassroomMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;
    private final ClassroomMapper classroomMapper;

    public ClassroomController(ClassroomService classroomService,
                               ClassroomMapper classroomMapper) {
        this.classroomService = classroomService;
        this.classroomMapper = classroomMapper;
    }

    @GetMapping
    public List<ClassroomResponseDto> getAll(){
        return classroomService.getAll()
                .stream()
                .map(classroomMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClassroomResponseDto getById(@PathVariable Long id) {
        return classroomMapper.mapToDto(classroomService.getById(id));
    }

    @PostMapping
    public ClassroomResponseDto add(@RequestBody @Valid ClassroomRequestDto classroomRequestDto) {
        Classroom classroom = classroomMapper.mapToModel(classroomRequestDto);
        classroomService.save(classroom);
        return classroomMapper.mapToDto(classroom);
    }

    @PutMapping("/{id}")
    public ClassroomResponseDto update(@PathVariable Long id,
                                       @RequestBody @Valid ClassroomRequestDto classroomRequestDto) {
        Classroom classroom = classroomMapper.mapToModel(classroomRequestDto);
        classroom.setId(id);
        classroomService.update(classroom);
        return classroomMapper.mapToDto(classroom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        classroomService.delete(id);
    }
}
