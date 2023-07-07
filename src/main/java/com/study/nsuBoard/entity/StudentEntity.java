package com.study.nsuBoard.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Getter
@Setter
@Builder
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;


    @Column
    private String student;

    @Column
    private String Password;

    @Column
    private String nickName;

    @Column
    private String department;

    @OneToOne(mappedBy = "student", fetch = LAZY)
    private Reservation reservation;

    @OneToMany(mappedBy = "student")
    private List<BoardEntity> boardEntities = new ArrayList<>();

    public StudentEntity() {

    }
}