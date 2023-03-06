package com.study.nsuBoard.controller;



import com.study.nsuBoard.entity.ClassRoom;
import com.study.nsuBoard.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class ChooseController {
    private final ClassRoomService classRoomService;

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
        return "Floor/choice1";
    }

    @GetMapping("/2")
    public String number2() {
        return "Floor/choice2";
    }

    @GetMapping("/2th floor")
    public String floor2() {
        return "ClassRoom/classRoom_2F";
    }
    @GetMapping("/3th floor")
    public String floor3() {
        return "ClassRoom/classRoom_3F";
    }
    @GetMapping("/4th floor")
    public String floor4() {
        return "ClassRoom/classRoom_4F";
    }
    @GetMapping("/5th floor")
    public String floor5() {
        return "ClassRoom/classRoom_5F";
    }

    @GetMapping("/classroom1")
    public String classroom1Form() {
        return "ClassRoom/seatNumber";
    }
    @PostMapping("/classroom1")
    public String classroom1(ClassRoom classRoom){
        classRoomService.join(classRoom);
        return "ClassRoom/seatNumber";
    }

}


