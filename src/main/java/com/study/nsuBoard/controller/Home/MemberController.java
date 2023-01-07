package com.study.nsuBoard.controller.Home;

import com.study.nsuBoard.dto.StudentDto;
import com.study.nsuBoard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "MainPage/chooseBoardOrReservation";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute StudentDto studentDto , Model model, HttpSession session){
        StudentDto loginResult = studentService.login(studentDto);

        if(loginResult != null){
            model.addAttribute("message", "회원가입이 완료되었습니다.");
            model.addAttribute("searchUrl", "/HomePage/home");
            session.setAttribute("loginId" , loginResult.getStudent());

            return "MainPage/chooseBoardOrReservation";
        }else {
            return "MainPage/chooseBoardOrReservation";
        }

    }

    @GetMapping("/LogOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "HomePage/home";
    }


}
