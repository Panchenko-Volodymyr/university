package com.example.university.service.impl;


import com.example.university.model.Day;
import com.example.university.repository.DayDao;
import com.example.university.service.DayService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    private final DayDao dayDao;

    public DayServiceImpl(DayDao dayDao) {
        this.dayDao = dayDao;
    }

    @Override
    public Day save(Day day) {
        return dayDao.save(day);
    }

    @Override
    public Day update(Day day) {
        return dayDao.save(day);
    }

    @Override
    public Day getById(Long id) {
        return dayDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find day by id " + id));
    }

    @Override
    public List<Day> getAll() {
        return dayDao.findAll();
    }

    @Override
    public void delete(Long id) {
        dayDao.deleteById(id);
    }
}
