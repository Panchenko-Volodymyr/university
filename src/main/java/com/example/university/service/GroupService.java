package com.example.university.service;

import com.example.university.model.Group;
import java.util.List;

public interface GroupService {
    Group save(Group group);

    Group update(Group group);

    Group getById(Long id);

    List<Group> getAll();

    void delete(Long id);
}
