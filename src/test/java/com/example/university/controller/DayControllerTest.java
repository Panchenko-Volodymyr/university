package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.university.model.Day;
import com.example.university.repository.DayDao;
import com.example.university.service.DayService;
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
public class DayControllerTest {
    private static final Day TEST_DAY1 = new Day(10L, Day.DayOfWeek.FRIDAY);
    private static final Long TEST_ID = 10L;

    @Autowired
    private DayService dayService;
    @MockBean
    private DayDao dayDao;

    @Test
    public void whenGetAllDaysTest() throws Exception {
        when(dayDao.findAll()).thenReturn(Stream
                .of(TEST_DAY1, new Day(11L, Day.DayOfWeek.FRIDAY))
                .collect(Collectors.toList()));
        assertEquals(2, dayService.getAll().size());
    }

    @Test
    public void whenGetDayByIdTest() {
        when(dayDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_DAY1));
        Day actual = dayService.getById(TEST_ID);
        assertEquals(TEST_DAY1, actual);
    }

    @Test
    public void whenGetDayByIdShouldThrownRuntimeExceptionTest() {
        when(dayDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> dayService.getById(TEST_ID));
    }

    @Test
    public void whenAddDayTest() {
        when(dayDao.save(TEST_DAY1)).thenReturn(TEST_DAY1);
        Day actual = dayService.save(TEST_DAY1);
        assertEquals(TEST_DAY1, actual);
    }

    @Test
    public void whenUpdateDayTest() {
        when(dayDao.save(TEST_DAY1)).thenReturn(TEST_DAY1);
        Day actual = dayService.update(TEST_DAY1);
        assertEquals(TEST_DAY1, actual);
    }

    @Test
    public void whenDeleteDayTest() {
        dayService.delete(TEST_ID);
        verify(dayDao, times(1)).deleteById(TEST_ID);
    }
}
