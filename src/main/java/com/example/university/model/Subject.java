package com.example.university.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "names_of_subjects")
    private String nameOfSubject;

    public Subject(Long id, String nameOfSubject) {
        this.id = id;
        this.nameOfSubject = nameOfSubject;
    }
}
