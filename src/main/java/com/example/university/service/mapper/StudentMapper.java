package com.example.university.service.mapper;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.model.Student;

import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements RequestDtoMapper<StudentRequestDto, Student>,
        ResponseDtoMapper<StudentResponseDto, Student> {
    @Override
    public Student mapToModel(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setGroup(studentRequestDto.getGroup());
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setGroup(student.getGroup());
        return studentResponseDto;
    }
}
