/*
package com.study.nsuBoard.dto;

import com.study.nsuBoard.entity.Student;
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
    private String studentId;
    private String studentPassword;
    private String nickName;
    private String department;

    public static StudentDto toStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentPassword(student.getStudentPassword());
        studentDto.setnickName(student.getnickName());
        studentDto.setDepartment(student.getDepartment());
        return studentDto;
    }

}
*/
