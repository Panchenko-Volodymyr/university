package com.example.university.service.impl;


import com.example.university.model.Group;
import com.example.university.repository.GroupDao;
import com.example.university.service.GroupService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group update(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group getById(Long id) {
        return groupDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find group by id " + id));
    }

    @Override
    public List<Group> getAll() {
        return groupDao.findAll();
    }

    @Override
    public void delete(Long id) {
        groupDao.deleteById(id);
    }
}
