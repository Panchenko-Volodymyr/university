package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.repository.StudentDao;
import com.example.university.service.StudentService;
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
public class StudentControllerTest {
    private static final Student TEST_STUDENT1 =
            new Student(50L,"Volodymyr","Panchenko",new Group(5L,"123"));
    private static final Student TEST_STUDENT2 =
            new Student(51L, "Vlad","Shvets",new Group(6L,"321"));
    private static final Long TEST_ID = 50L;

    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentDao studentDao;

    @Test
    public void whenGetAllStudentsTest() throws Exception {
        when(studentDao.findAll()).thenReturn(Stream
                .of(TEST_STUDENT1, TEST_STUDENT2)
                .collect(Collectors.toList()));
        assertEquals(2, studentService.getAll().size());
    }

    @Test
    public void whenGetStudentByIdTest() {
        when(studentDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_STUDENT1));
        Student actual = studentService.getById(TEST_ID);
        assertEquals(TEST_STUDENT1, actual);
    }

    @Test
    public void whenGetStudentByIdShouldThrownRuntimeExceptionTest() {
        when(studentDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> studentService.getById(TEST_ID));
    }

    @Test
    public void whenAddStudentTest() {
        when(studentDao.save(TEST_STUDENT1)).thenReturn(TEST_STUDENT1);
        Student actual = studentService.save(TEST_STUDENT1);
        assertEquals(TEST_STUDENT1, actual);
    }

    @Test
    public void whenUpdateStudentTest() {
        when(studentDao.save(TEST_STUDENT1)).thenReturn(TEST_STUDENT1);
        Student actual = studentService.update(TEST_STUDENT1);
        assertEquals(TEST_STUDENT1, actual);
    }

    @Test
    public void whenDeleteStudentTest() {
        studentService.delete(TEST_ID);
        verify(studentDao, times(1)).deleteById(TEST_ID);
    }
}
