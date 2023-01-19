package com.study.nsuBoard.controller;

import com.study.nsuBoard.Form.StudentForm;
import com.study.nsuBoard.entity.Student;
import com.study.nsuBoard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class StudentController {

    private final StudentService studentService;
    // 회원가입 기능 구현

    @GetMapping("/save")
    public String saveForm(Model model) {
        model.addAttribute("StudentForm", new StudentForm());
        return "HomePage/save";
    }

    @PostMapping("/save")
    public String save(@Validated StudentForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "HomePage/save";
        }
        Student student = new Student();
        student.setStudent(form.getStudent());
        student.setNickName(form.getNickName());
        student.setPassword(form.getPassWord());
        student.setDepartment(form.getDepartment());

        studentService.join(student);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        studentService.login();


//        model.addAttribute("message", "로그인이 완료되었습니다.");
//        model.addAttribute("searchUrl", "/MainPage/chooseBoardOrReservation");
        return "MainPage/chooseBoardOrReservation";
    }


    @GetMapping("/LogOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "HomePage/home";
    }


}
