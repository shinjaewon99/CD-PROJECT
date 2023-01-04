package com.study.nsuBoard.entity;


import com.study.nsuBoard.dto.StudentDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String student;

    @Column
    private String studentPassword;

    @Column
    private String studentPasswordCheck;

    @Column
    private String studentName;

    @Column
    private String department;

    public static StudentEntity toStudentEntity(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setStudent(studentDto.getStudentName());
        studentEntity.setStudentPassword(studentDto.getStudentPassword());
        studentEntity.setStudentPasswordCheck(studentDto.getStudentPasswordCheck());
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setDepartment(studentDto.getDepartment());

        return studentEntity;
    }
}
