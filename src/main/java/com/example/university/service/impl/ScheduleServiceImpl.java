package com.example.university.service.impl;


import com.example.university.model.Day;
import com.example.university.model.Schedule;
import com.example.university.repository.DayDao;
import com.example.university.repository.ScheduleDao;
import com.example.university.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDao scheduleDao;
    private final DayDao dayDao;

    public ScheduleServiceImpl(ScheduleDao scheduleDao, DayDao dayDao) {
        this.scheduleDao = scheduleDao;
        this.dayDao = dayDao;
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleDao.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return scheduleDao.save(schedule);
    }

    @Override
    public Schedule getById(Long id) {
        return scheduleDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find schedule by id " + id));
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleDao.findAll();
    }

    @Override
    public void delete(Long id) {
        scheduleDao.deleteById(id);
    }

    @Override
    public List<Schedule> getScheduleByStudentIdAndDayOfWeek(Long id, String dayOfWeek) {
        return scheduleDao
                .getScheduleByStudentIdAndDayOfWeek(id,
                        Day.DayOfWeek.valueOf(dayOfWeek)).orElseThrow(() ->
                        new RuntimeException("Can't get schedule by student id "
                                + id + " and date " + dayOfWeek));
    }
}
