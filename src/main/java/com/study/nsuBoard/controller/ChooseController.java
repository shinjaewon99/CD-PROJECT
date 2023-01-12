package com.study.nsuBoard.controller;


import com.study.nsuBoard.dto.SeatDto;
import com.study.nsuBoard.entity.ClassRoomEntity;
import com.study.nsuBoard.repository.ReservationRepository;
import com.study.nsuBoard.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nsuBoard")
public class ChooseController {
    private final ReservationService reservationService;

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
        return "ClassRoom/seatNumber";
    }


    @GetMapping("/seat1")
    public String getSeat1() {


        return "ClassRoom/userSeet";
    }

    @PostMapping("/seat1")
    public String setSeat1(@ModelAttribute SeatDto seatDto, Model model){

        reservationService.reservationSave(seatDto);
        System.out.println(seatDto);
        model.addAttribute("message", "예약이 완료되었습니다.");
        model.addAttribute("searchUrl", "classroom1");

        return "Board/message";
    }


}


