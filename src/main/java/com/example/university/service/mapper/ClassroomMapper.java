package com.example.university.service.mapper;

import com.example.university.dto.request.ClassroomRequestDto;
import com.example.university.dto.response.ClassroomResponseDto;
import com.example.university.model.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapper implements ResponseDtoMapper<ClassroomResponseDto, Classroom>,
        RequestDtoMapper<ClassroomRequestDto, Classroom> {
    @Override
    public Classroom mapToModel(ClassroomRequestDto classroomRequestDto) {
        Classroom classroom = new Classroom();
        classroom.setNameOfClassroom(classroomRequestDto.getNameOfClassroom());
        return classroom;
    }

    @Override
    public ClassroomResponseDto mapToDto(Classroom classroom) {
        ClassroomResponseDto classroomResponseDto = new ClassroomResponseDto();
        classroomResponseDto.setId(classroom.getId());
        classroomResponseDto.setNameOfClassroom(classroom.getNameOfClassroom());
        return classroomResponseDto;
    }
}
