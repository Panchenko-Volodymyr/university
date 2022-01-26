package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.university.model.Subject;
import com.example.university.repository.SubjectDao;
import com.example.university.service.SubjectService;
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
public class SubjectControllerTest {
    private static final Subject TEST_SUBJECT1 = new Subject(13L,"Math");
    private static final Subject TEST_SUBJECT2 = new Subject(12L, "Philosophy");
    private static final Long TEST_ID = 13L;

    @Autowired
    private SubjectService subjectService;
    @MockBean
    private SubjectDao subjectDao;

    @Test
    public void whenGetAllSubjectsTest() throws Exception {
        when(subjectDao.findAll()).thenReturn(Stream
                .of(TEST_SUBJECT1, TEST_SUBJECT2)
                .collect(Collectors.toList()));
        assertEquals(2, subjectService.getAll().size());
    }

    @Test
    public void whenGetSubjectByIdTest() {
        when(subjectDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_SUBJECT1));
        Subject actual = subjectService.getById(TEST_ID);
        assertEquals(TEST_SUBJECT1, actual);
    }

    @Test
    public void whenGetSubjectByIdShouldThrownRuntimeExceptionTest() {
        when(subjectDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> subjectService.getById(TEST_ID));
    }

    @Test
    public void whenAddSubjectTest() {
        when(subjectDao.save(TEST_SUBJECT1)).thenReturn(TEST_SUBJECT1);
        Subject actual = subjectService.save(TEST_SUBJECT1);
        assertEquals(TEST_SUBJECT1, actual);
    }

    @Test
    public void whenUpdateSubjectTest() {
        when(subjectDao.save(TEST_SUBJECT1)).thenReturn(TEST_SUBJECT1);
        Subject actual = subjectService.update(TEST_SUBJECT1);
        assertEquals(TEST_SUBJECT1, actual);
    }

    @Test
    public void whenDeleteSubjectTest() {
        subjectService.delete(TEST_ID);
        verify(subjectDao, times(1)).deleteById(TEST_ID);
    }
}
