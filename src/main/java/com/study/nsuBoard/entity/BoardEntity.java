package com.study.nsuBoard.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {

    @Id
    // 기본키를 자동으로 생성해주는 어노테이션
    // strategy(전략)에 따라 4가지 방법이 있다. mysql에서는 IDENTITY 전략 사용 (AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImage;
    private String boardVideo;

    private String boardWriterStudentId;
    private String boardWriteNickName;
    private String boardWriteDate;

    private Integer boardClickCount;
    private Integer boardLikeCount;
    private Integer boardCommentCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CommentEntitiy> commentEntitiyList = new ArrayList<>();

}
