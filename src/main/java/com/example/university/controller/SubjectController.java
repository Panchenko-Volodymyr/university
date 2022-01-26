package com.example.university.controller;

import com.example.university.dto.request.SubjectRequestDto;
import com.example.university.dto.response.SubjectResponseDto;
import com.example.university.model.Subject;
import com.example.university.service.SubjectService;
import com.example.university.service.mapper.SubjectMapper;
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
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    public SubjectController(SubjectService subjectService,
                             SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @GetMapping
    public List<SubjectResponseDto> getAll() {
        return subjectService.getAll()
                .stream()
                .map(subjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SubjectResponseDto getById(@PathVariable Long id) {
        return subjectMapper.mapToDto(subjectService.getById(id));
    }

    @PostMapping
    public SubjectResponseDto add(@RequestBody @Valid SubjectRequestDto subjectRequestDto) {
        Subject subject = subjectMapper.mapToModel(subjectRequestDto);
        subjectService.save(subject);
        return subjectMapper.mapToDto(subject);
    }

    @PutMapping("/{id}")
    public SubjectResponseDto update(@PathVariable Long id,
                                     @RequestBody SubjectRequestDto subjectRequestDto) {
        Subject student = subjectMapper.mapToModel(subjectRequestDto);
        student.setId(id);
        subjectService.update(student);
        return subjectMapper.mapToDto(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
