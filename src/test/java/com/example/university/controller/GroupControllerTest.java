package com.example.university.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.university.repository.GroupDao;
import com.example.university.service.GroupService;
import com.example.university.model.Group;
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
public class GroupControllerTest {
    private static final Group TEST_GROUP1 = new Group(5L,"111M");
    private static final Group TEST_GROUP2 = new Group(6L, "123");
    private static final Long TEST_ID = 5L;

    @Autowired
    private GroupService groupService;
    @MockBean
    private GroupDao groupDao;

    @Test
    public void whenGetAllGroupsTest() throws Exception {
        when(groupDao.findAll()).thenReturn(Stream
                .of(TEST_GROUP1, TEST_GROUP2)
                .collect(Collectors.toList()));
        assertEquals(2, groupService.getAll().size());
    }

    @Test
    public void whenGetGroupByIdTest() {
        when(groupDao.findById(TEST_ID)).thenReturn(Optional.ofNullable(TEST_GROUP1));
        Group actual = groupService.getById(TEST_ID);
        assertEquals(TEST_GROUP1, actual);
    }

    @Test
    public void whenGetGroupByIdShouldThrownRuntimeExceptionTest() {
        when(groupDao.findById(TEST_ID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> groupService.getById(TEST_ID));
    }

    @Test
    public void whenAddGroupTest() {
        when(groupDao.save(TEST_GROUP1)).thenReturn(TEST_GROUP1);
        Group actual = groupService.save(TEST_GROUP1);
        assertEquals(TEST_GROUP1, actual);
    }

    @Test
    public void whenUpdateGroupTest() {
        when(groupDao.save(TEST_GROUP1)).thenReturn(TEST_GROUP1);
        Group actual = groupService.update(TEST_GROUP1);
        assertEquals(TEST_GROUP1, actual);
    }

    @Test
    public void whenDeleteGroupTest() {
        groupService.delete(TEST_ID);
        verify(groupDao, times(1)).deleteById(TEST_ID);
    }
}
