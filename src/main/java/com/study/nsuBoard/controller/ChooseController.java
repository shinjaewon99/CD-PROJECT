package com.study.nsuBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
}


