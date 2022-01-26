package com.example.university.service.mapper;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements ResponseDtoMapper<GroupResponseDto, Group>,
        RequestDtoMapper<GroupRequestDto, Group> {
    @Override
    public Group mapToModel(GroupRequestDto groupRequestDto) {
        Group group = new Group();
        group.setGroupName(group.getGroupName());
        group.setSchedules(groupRequestDto.getSchedules());
        return group;
    }

    @Override
    public GroupResponseDto mapToDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setId(group.getId());
        groupResponseDto.setGroupName(group.getGroupName());
        groupResponseDto.setSchedules(group.getSchedules());
        return groupResponseDto;
    }
}
