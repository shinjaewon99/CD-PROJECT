package com.study.nsuBoard.dto;

import com.study.nsuBoard.entity.StudentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDto {

    private Long id;
    private String student;
    private String studentPassword;
    private String studentPasswordCheck;
    private String studentName;
    private String department;

    public static StudentDto toStudentDto(StudentEntity studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setStudent(studentEntity.getStudent());
        studentDto.setStudentPassword(studentEntity.getStudentPassword());
        studentDto.setStudentPasswordCheck(studentEntity.getStudentPasswordCheck());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setDepartment(studentEntity.getDepartment());
        return studentDto;
    }

}
