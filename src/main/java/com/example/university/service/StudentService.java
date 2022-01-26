package com.example.university.service;

import com.example.university.model.Student;
import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student update(Student student);

    Student getById(Long id);

    List<Student> getAll();

    void delete(Long id);
}
