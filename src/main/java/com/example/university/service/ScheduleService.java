package com.example.university.service;

import com.example.university.model.Schedule;
import java.util.List;

public interface ScheduleService {
    Schedule save(Schedule schedule);

    Schedule update(Schedule schedule);

    Schedule getById(Long id);

    List<Schedule> getAll();

    void delete(Long id);

    List<Schedule> getScheduleByStudentIdAndDayOfWeek(Long id, String dayOfWeek);
}
