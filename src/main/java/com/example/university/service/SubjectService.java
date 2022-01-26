package com.example.university.service;

import com.example.university.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject save(Subject subject);

    Subject update(Subject subject);

    Subject getById(Long id);

    List<Subject> getAll();

    void delete(Long id);
}
