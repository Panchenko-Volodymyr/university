package com.example.university.repository;

import com.example.university.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomDao extends JpaRepository<Classroom, Long> {
}
