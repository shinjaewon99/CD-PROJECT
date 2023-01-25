package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.ReservationDto;
import com.study.nsuBoard.entity.Board;
import com.study.nsuBoard.entity.ClassRoom;
import com.study.nsuBoard.entity.Reservation;
import com.study.nsuBoard.repository.ClassRoomRepository;
import com.study.nsuBoard.repository.ReservationRepository;
import com.study.nsuBoard.timeutil.time;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    public List<Reservation> findAllReservation(){
        return reservationRepository.findAll();
    }

    public Long reservation(Reservation reservation){
        reservationRepository.save(reservation);
        return reservation.getId();
    }


  /*  public void reservation(Long classroomId,
                            String setNumber,
                            ReservationDto formDto) {

        Optional<ClassRoom> optionalClassroom = classRoomRepository.findBydClassRoomId(classroomId);

        LocalDateTime startDate = time.getLocalDateTime(formDto.getStartDate(), formDto.getStartHour(), formDto.getStartMinute());


        LocalDateTime endDate = time.getLocalDateTime(formDto.getEndDate(), formDto.getEndHour(), formDto.getEndMinute());


        Reservation reservation = Reservation.createReservation(optionalClassroom.get().getId(), startDate, setNumber, endDate);


        reservationRepository.save(reservation);

    }*/
}
