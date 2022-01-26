package com.example.university.service.impl;


import com.example.university.repository.SubjectDao;
import com.example.university.model.Subject;
import com.example.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectDao subjectDao;

    @Autowired
    public SubjectServiceImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public Subject save(Subject subject) {
        return subjectDao.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectDao.save(subject);
    }

    @Override
    public Subject getById(Long id) {
        return subjectDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find subject by id "+ id));
    }

    @Override
    public List<Subject> getAll() {
        return subjectDao.findAll();
    }

    @Override
    public void delete(Long id) {
        subjectDao.deleteById(id);
    }
}
