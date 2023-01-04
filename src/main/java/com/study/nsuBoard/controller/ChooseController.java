package com.study.nsuBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ChooseController {



    @GetMapping("/nsuBoard/chooseBoardOrReservation")
    public String chooseForm(){

        return "MainPage/chooseBoardOrReservation";
    }

    @GetMapping("/nsuBoard/Board")
    public String board(){
        return "redirect:/board/list";
    }
}
