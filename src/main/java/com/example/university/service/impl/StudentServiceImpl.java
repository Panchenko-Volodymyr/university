package com.example.university.service.impl;

import com.example.university.model.Student;
import com.example.university.repository.StudentDao;
import com.example.university.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find student by id " + id));
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(Long id) {
        studentDao.deleteById(id);
    }
}
