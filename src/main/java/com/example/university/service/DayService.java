package com.example.university.service;

import com.example.university.model.Day;
import java.util.List;

public interface DayService {
    Day save(Day day);

    Day update(Day day);

    Day getById(Long id);

    List<Day> getAll();

    void delete(Long id);
}
