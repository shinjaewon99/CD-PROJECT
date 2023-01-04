package com.study.nsuBoard.controller.Home;

import com.study.nsuBoard.dto.StudentDto;
import com.study.nsuBoard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class MemberController {

    private final StudentService studentService;
    // 회원가입 기능 구현

    @GetMapping("/save")
    public String saveForm() {
        return "HomePage/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentDto studentDto){

        System.out.println("studentDto = " + studentDto);
        studentService.save(studentDto);
        return "HomePage/login";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "HomePage/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute StudentDto studentDto , HttpSession session){
        StudentDto loginResult = studentService.login(studentDto);

        if(loginResult != null){
            session.setAttribute("loginId" , loginResult.getId());
            return "MainPage/chooseBoardOrReservation";
        }else {
            return "HomePage/login";
        }

    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "HomePage/home";
    }


}
