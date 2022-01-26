package com.example.university.service.mapper;

import com.example.university.dto.request.SubjectRequestDto;
import com.example.university.dto.response.SubjectResponseDto;
import com.example.university.model.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper implements ResponseDtoMapper<SubjectResponseDto, Subject>,
        RequestDtoMapper<SubjectRequestDto, Subject> {
    @Override
    public Subject mapToModel(SubjectRequestDto subjectRequestDto) {
        Subject subject = new Subject();
        subject.setNameOfSubject(subjectRequestDto.getNameOfSubject());
        return subject;
    }

    @Override
    public SubjectResponseDto mapToDto(Subject subject) {
        SubjectResponseDto subjectResponseDto = new SubjectResponseDto();
        subjectResponseDto.setId(subject.getId());
        subjectResponseDto.setNameOfSubject(subject.getNameOfSubject());
        return subjectResponseDto;
    }
}
