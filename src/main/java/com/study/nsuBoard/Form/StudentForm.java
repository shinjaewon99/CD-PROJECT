package com.study.nsuBoard.Form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class StudentForm {

    @NotEmpty(message = "학번은 필수 입니다")
    private String student;
    private String passWord;
    private String nickName;
    private String department;
}
