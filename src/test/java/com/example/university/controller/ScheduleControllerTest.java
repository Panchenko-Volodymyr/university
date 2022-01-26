package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.university.model.Classroom;
import com.example.university.model.Day;
import com.example.university.model.Group;
import com.example.university.model.Schedule;
import com.example.university.model.Student;
import com.example.university.model.Subject;
import com.example.university.repository.ScheduleDao;
import com.example.university.service.ScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ScheduleControllerTest {
    private static final Group TEST_GROUP = new Group(10L, "432");
    private static final Student TEST_STUDENT = new Student(40L,"Volodymyr","Panchenko",TEST_GROUP);
    private static final Schedule TEST_SCHEDULE1 =
            new Schedule(50L, TEST_GROUP, new Day(10L, Day.DayOfWeek.FRIDAY),
                    new Subject(15L, "Math"), new Classroom(10L, "222B"));
    private static final Schedule TEST_SCHEDULE2 =
            new Schedule(51L, TEST_GROUP, new Day(10L, Day.DayOfWeek.FRIDAY),
                    new Subject(16L, "Philosophy"), new Classroom(11L, "223"));
    private static final Long TEST_ID = 50L;

    @Autowired
    private ScheduleService scheduleService;
    @MockBean
    private ScheduleDao scheduleDao;

    @Test
    public void whenGetScheduleByStudentIdAndDateShouldThrownRuntimeExceptionTest() {
        String dayOfWeek = "FRIDAY";
        when(scheduleDao.getScheduleByStudentIdAndDayOfWeek(TEST_STUDENT.getId(), Day.DayOfWeek.FRIDAY))
                .thenReturn(Optional.of(Stream
                        .of(TEST_SCHEDULE1, TEST_SCHEDULE2)
                        .collect(Collectors.toList())));
        assertEquals(2, scheduleService.getScheduleByStudentIdAndDayOfWeek(TEST_STUDENT.getId(), dayOfWeek).size());
    }

    @Test
    public void whenGetScheduleByStudentIdAndDateTest() {
        String dayOfWeek = "FRIDAY";
        when(scheduleDao.getScheduleByStudentIdAndDayOfWeek(TEST_STUDENT.getId(), Day.DayOfWeek.SATURDAY)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> scheduleService.getScheduleByStudentIdAndDayOfWeek(TEST_STUDENT.getId(), dayOfWeek));
    }

    @Test
    public void whenGetAllScheduleTest() throws Exception {
        when(scheduleDao.findAll()).thenReturn(Stream
                .of(TEST_SCHEDULE1, TEST_SCHEDULE2)
                                .collect(Collectors.toList()));
        assertEquals(2, scheduleService.getAll().size());
    }

    @Test
    public void whenGetClassroomByIdTest() {
        when(scheduleDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_SCHEDULE1));
        Schedule actual = scheduleService.getById(TEST_ID);
        assertEquals(TEST_SCHEDULE1, actual);
    }

    @Test
    public void whenGetClassroomByIdShouldThrownRuntimeExceptionTest() {
        when(scheduleDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> scheduleService.getById(TEST_ID));
    }

    @Test
    public void whenAddClassroomTest() {
        when(scheduleDao.save(TEST_SCHEDULE1)).thenReturn(TEST_SCHEDULE1);
        Schedule actual = scheduleService.save(TEST_SCHEDULE1);
        assertEquals(TEST_SCHEDULE1, actual);
    }

    @Test
    public void whenUpdateClassroomTest() {
        when(scheduleDao.save(TEST_SCHEDULE1)).thenReturn(TEST_SCHEDULE1);
        Schedule actual = scheduleService.update(TEST_SCHEDULE1);
        assertEquals(TEST_SCHEDULE1, actual);
    }

    @Test
    public void whenDeleteClassroomTest() {
        scheduleService.delete(TEST_ID);
        verify(scheduleDao, times(1)).deleteById(TEST_ID);
    }
}
