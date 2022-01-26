package com.example.university.repository;

import com.example.university.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayDao extends JpaRepository<Day, Long> {
}
