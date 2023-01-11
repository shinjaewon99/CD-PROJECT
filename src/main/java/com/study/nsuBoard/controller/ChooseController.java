package com.study.nsuBoard.controller;

import com.study.nsuBoard.dto.AbleTimeDto;
import com.study.nsuBoard.entity.ClassRoomEntity;
import com.study.nsuBoard.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class ChooseController {
    private ClassRoomService classRoomService;

    @GetMapping("/chooseBoardOrReservation")
    public String chooseForm() {

        return "MainPage/chooseBoardOrReservation";
    }

    @GetMapping("/Board")
    public String board() {
        return "redirect:/board/list";
    }

    @GetMapping("/Reservation")
    public String reservation() {
        return "MainPage/building";
    }

    @GetMapping("/1")
    public String number1() {
        return "Floor/choice";
    }

    @GetMapping("/2")
    public String number2() {
        return "Floor/choice";
    }

    @GetMapping("/2th floor")
    public String floor2() {
        return "ClassRoom/classRoom";
    }

    @GetMapping("/classroom1")
    public String classroom1() {
        return "ClassRoom/seetNumber";
    }

    @GetMapping("/seat1")
    public String getSeat1(@PathVariable Long id, Model model) {
        List<AbleTimeDto> times = classRoomService.getAvailableTimes(id);
//        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("times", times);
        return "ClassRoom/userSeet";
    }

}


