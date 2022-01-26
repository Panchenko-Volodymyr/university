package com.example.university.controller;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.model.Group;
import com.example.university.service.GroupService;
import com.example.university.service.mapper.GroupMapper;
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
@RequestMapping("/groups")
public class GroupController {
    private final GroupMapper groupMapper;
    private final GroupService groupService;

    public GroupController(GroupMapper groupMapper,
                           GroupService groupService) {
        this.groupMapper = groupMapper;
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupResponseDto> getAll() {
        return groupService.getAll()
                .stream()
                .map(groupMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GroupResponseDto getById(@PathVariable Long id) {
        return groupMapper.mapToDto(groupService.getById(id));
    }

    @PostMapping
    public GroupResponseDto add(@RequestBody @Valid GroupRequestDto groupRequestDto) {
        Group group = groupMapper.mapToModel(groupRequestDto);
        groupService.save(group);
        return groupMapper.mapToDto(group);
    }

    @PutMapping("/{id}")
    public GroupResponseDto update(@PathVariable Long id,
                                   @RequestBody GroupRequestDto groupRequestDto) {
        Group group = groupMapper.mapToModel(groupRequestDto);
        group.setId(id);
        groupService.update(group);
        return groupMapper.mapToDto(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}
