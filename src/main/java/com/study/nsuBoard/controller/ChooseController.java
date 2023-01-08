package com.study.nsuBoard.controller;

import com.study.nsuBoard.dto.ClassRoomDto;
import com.study.nsuBoard.service.ClassRoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class ChooseController {



    @GetMapping("/chooseBoardOrReservation")
    public String chooseForm(){

        return "MainPage/chooseBoardOrReservation";
    }

    @GetMapping("/Board")
    public String board(){
        return "redirect:/board/list";
    }
    @GetMapping("/Reservation")
    public String reservation(){
        return "MainPage/building";
    }

    @GetMapping("/1")
    public String number1(){
        return "Floor/choice";
    }
    @GetMapping("/2")
    public String number2(){
        return "Floor/choice";
    }
    @GetMapping("/2th floor")
    public String floor2(){
        return "ClassRoom/classRoom";
    }

    @GetMapping("/classroom1")
    public String classroom1(){
        return "ClassRoom/seetNumber";
    }

    @GetMapping("/seat1")
    public String getSeat1(@PathVariable Long reservationId,
                           @RequestParam Long classRoomId, Model model ){

        List<ClassRoomDto> times = ClassRoomServiceImpl.getAvailableTime(classRoomId);
        model.addAttribute("reservationId", reservationId);

        return "";
    }
}


