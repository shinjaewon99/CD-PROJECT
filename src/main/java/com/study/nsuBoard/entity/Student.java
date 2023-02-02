package com.study.nsuBoard.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Student {
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
    private List<Board> boards = new ArrayList<>();

    public void addBoard(Board board) {
        boards.add(board);
        board.setStudent(this);
    }


  /*  public static Student toStudent(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setStudentId(studentDto.getStudentId());
        student.setStudentPassword(studentDto.getStudentPassword());
        student.setnickName(studentDto.getnickName());
        student.setDepartment(studentDto.getDepartment());

        return student;
    }*/
}
