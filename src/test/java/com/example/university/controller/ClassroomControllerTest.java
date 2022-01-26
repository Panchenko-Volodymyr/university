package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.university.model.Classroom;
import com.example.university.repository.ClassroomDao;
import com.example.university.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClassroomControllerTest {
    private static final Classroom TEST_CLASSROOM1 = new Classroom(10L, "333");
    private static final Long TEST_ID = 10L;

    @Autowired
    private ClassroomService classroomService;

    @MockBean
    private ClassroomDao classroomDao;

    @Test
    public void whenGetAllDaysTest() throws Exception {
        when(classroomDao.findAll()).thenReturn(Stream
                .of(TEST_CLASSROOM1, new Classroom(11L, "222"))
                .collect(Collectors.toList()));
        assertEquals(2, classroomService.getAll().size());
    }

    @Test
    public void whenGetDayByIdTest() {
        when(classroomDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_CLASSROOM1));
        Classroom actual = classroomService.getById(TEST_ID);
        assertEquals(TEST_CLASSROOM1, actual);
    }

    @Test
    public void whenGetDayByIdShouldThrownRuntimeExceptionTest() {
        when(classroomDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> classroomService.getById(TEST_ID));
    }

    @Test
    public void whenAddDayTest() {
        when(classroomDao.save(TEST_CLASSROOM1)).thenReturn(TEST_CLASSROOM1);
        Classroom actual = classroomService.save(TEST_CLASSROOM1);
        assertEquals(TEST_CLASSROOM1, actual);
    }

    @Test
    public void whenUpdateDayTest() {
        when(classroomDao.save(TEST_CLASSROOM1)).thenReturn(TEST_CLASSROOM1);
        Classroom actual = classroomService.update(TEST_CLASSROOM1);
        assertEquals(TEST_CLASSROOM1, actual);
    }

    @Test
    public void whenDeleteDayTest() {
        classroomService.delete(TEST_ID);
        verify(classroomDao, times(1)).deleteById(TEST_ID);
    }
}
