package com.study.nsuBoard.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 무분별한 생성자 생성 방지 private 접근자로 하게되면 Spring에서도 접근을 못하게됨
public class StudentEntity {

    @Id
    private String studentId; // 학번
    private String studentPassword;
    private String studentNickName;
    private String studentDepartment; // 학과

    @OneToOne(mappedBy = "student", fetch = LAZY)
    private Reservation reservation;

    @OneToMany(mappedBy = "student")
    private List<BoardEntity> boardEntities = new ArrayList<>();

}
