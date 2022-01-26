package com.example.university.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Group group;
    @ManyToOne
    private Day day;
    @ManyToOne
    private Subject subjects;
    @ManyToOne
    private Classroom classroom;

    public Schedule(Long id, Group group, Day day, Subject subjects, Classroom classroom) {
        this.id = id;
        this.group = group;
        this.day = day;
        this.subjects = subjects;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Schedule{"
                + "id=" + id
                + ", group=" + group.getGroupName()
                + ", day=" + day
                + ", subjects=" + subjects.getNameOfSubject()
                + ", classroom=" + classroom.getNameOfClassroom()
                + '}';
    }
}
