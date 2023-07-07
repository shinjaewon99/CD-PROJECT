package com.study.nsuBoard.service;

import com.study.nsuBoard.entity.ClassRoom;
import com.study.nsuBoard.entity.Reservation;
import com.study.nsuBoard.repository.ClassRoomRepository;
import com.study.nsuBoard.repository.ReservationRepository;
import com.study.nsuBoard.status.ReservationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ClassRoomRepository classRoomRepository;
    private final ReservationRepository reservationRepository;


    public List<ClassRoom> findAll() {
        Optional<List<ClassRoom>> result = classRoomRepository.findAll();

        return result.get();
    }

    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }

    public Long reservation(Reservation reservation) {
        reservation.setStatus(ReservationStatus.RESERVATION_OK);
        reservationRepository.save(reservation);
        return reservation.getId();
    }
}
