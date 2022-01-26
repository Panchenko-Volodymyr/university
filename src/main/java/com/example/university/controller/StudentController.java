package com.example.university.controller;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.model.Student;
import com.example.university.service.StudentService;
import com.example.university.service.mapper.StudentMapper;
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
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public  StudentController(StudentService studentService,
                              StudentMapper studentMapper){
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.getAll()
                .stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentResponseDto getById(@PathVariable Long id) {
        return studentMapper.mapToDto(studentService.getById(id));
    }

    @PostMapping
    public StudentResponseDto add(@RequestBody @Valid StudentRequestDto studentRequestDto) {
        Student student = studentMapper.mapToModel(studentRequestDto);
        studentService.save(student);
        return studentMapper.mapToDto(student);
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id,
                                   @RequestBody StudentRequestDto studentRequestDto) {
        Student student = studentMapper.mapToModel(studentRequestDto);
        student.setId(id);
        studentService.update(student);
        return studentMapper.mapToDto(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
