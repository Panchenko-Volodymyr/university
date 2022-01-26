package com.example.university.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_names")
    private String groupName;
    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;

    public Group(Long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }
}
