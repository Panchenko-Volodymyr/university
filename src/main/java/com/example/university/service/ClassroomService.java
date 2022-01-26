package com.example.university.service;

import com.example.university.model.Classroom;
import java.util.List;

public interface ClassroomService {
    Classroom save(Classroom classroom);

    Classroom update(Classroom classroom);

    Classroom getById(Long id);

    List<Classroom> getAll();

    void delete(Long id);
}
