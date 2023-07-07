package com.study.nsuBoard.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Getter
@Setter
public class BoardEntity {

    @Id
    // 기본키를 자동으로 생성해주는 어노테이션
    // strategy(전략)에 따라 4가지 방법이 있다. mysql에서는 IDENTITY 전략 사용 (AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column
    private String filename;

    @Column
    private String filepath;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CommentEntitiy> commentEntitiyList = new ArrayList<>();

}
