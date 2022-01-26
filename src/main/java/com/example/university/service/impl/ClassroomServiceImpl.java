package com.example.university.service.impl;

import com.example.university.model.Classroom;
import com.example.university.repository.ClassroomDao;
import com.example.university.service.ClassroomService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomDao classroomDao;

    public ClassroomServiceImpl(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @Override
    public Classroom getById(Long id) {
        return classroomDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find classroom by id " + id));
    }

    @Override
    public List<Classroom> getAll() {
        return classroomDao.findAll();
    }

    @Override
    public void delete(Long id) {
        classroomDao.deleteById(id);
    }
}
