package com.study.nsuBoard.controller;

import com.study.nsuBoard.Form.StudentForm;
import com.study.nsuBoard.entity.StudentEntity;
import com.study.nsuBoard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class StudentController {
    private final StudentService studentService;

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
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudent(form.getStudent());
        studentEntity.setNickName(form.getNickName());
        studentEntity.setPassword(form.getPassWord());
        studentEntity.setDepartment(form.getDepartment());

        studentService.join(studentEntity);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        studentService.login();

        return "MainPage/chooseBoardOrReservation";
    }

    @GetMapping("/LogOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "HomePage/home";
    }
}
