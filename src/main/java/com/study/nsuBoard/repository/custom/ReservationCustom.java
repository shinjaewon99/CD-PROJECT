package com.study.nsuBoard.repository.custom;

import com.study.nsuBoard.entity.Reservation;

import java.util.List;

public interface ReservationCustom {

    List<Reservation> findAvailableTimesByAvailableDateId(Long id);
}
