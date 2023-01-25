package com.study.nsuBoard.controller;

import com.study.nsuBoard.Form.ReservationForm;
import com.study.nsuBoard.entity.ClassRoom;
import com.study.nsuBoard.entity.Reservation;
import com.study.nsuBoard.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/nsuBoard/seat1")
    public String getSeat1(Model model) {
        model.addAttribute("ReservationForm", new ReservationForm());

        return "ClassRoom/userSeet";
    }

    @GetMapping("/classrooms")
    public String classroomList(Model model) {
        List<ClassRoom> classrooms = reservationService.findAll();
        model.addAttribute("classrooms", classrooms);
        return "ClassRoom/classRoomList";
    }

    @GetMapping("/nusBoard/list")
    public String list(Model model){
        List<Reservation> reservationList = reservationService.findAllReservation();
        model.addAttribute("reservationList", reservationList);
        return "ClassRoom/reservationList";

    }

    @PostMapping("/nsuBoard/reservation")
    public String reservationTimeMinute(@Validated ReservationForm form, Model model) {
        Reservation reservation = new Reservation();
        reservation.setSeatNumber(form.getSeatNumber());
        reservation.setHour(form.getHour());
        reservation.setMinute(form.getMinute());

        reservationService.reservation(reservation);
        System.out.println("ReservationController.reservationTimeMinute");

        model.addAttribute("message", "예약이 완료되었습니다.");
        model.addAttribute("searchUrl", "classroom1");


        return "Board/message";
    }


}
