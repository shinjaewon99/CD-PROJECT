package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.SeatDto;
import com.study.nsuBoard.entity.ClassRoomEntity;
import com.study.nsuBoard.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;



    public void reservationSave(SeatDto seatDto){
        reservationRepository.findByUserId(seatDto.getId());
        ClassRoomEntity classRoomEntity = ClassRoomEntity.toclassRoomEntity(seatDto);
        reservationRepository.save(classRoomEntity);
    }
}
