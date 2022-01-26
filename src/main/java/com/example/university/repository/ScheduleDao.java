package com.example.university.repository;


import com.example.university.model.Day;
import com.example.university.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
    @Query(value = "SELECT sch  from  Student st  " +
            "inner join st.group g " +
            "inner join g.schedules sch " +
            "inner join sch.day d WHERE st.id=?1 and d.dayOfWeek=?2")
    Optional<List<Schedule>> getScheduleByStudentIdAndDayOfWeek(Long id, Day.DayOfWeek dayOfWeek);
}
