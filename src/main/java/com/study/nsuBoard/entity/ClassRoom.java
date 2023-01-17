/*
package com.study.nsuBoard.entity;

import com.study.nsuBoard.dto.SeatDto;
import com.study.nsuBoard.status.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classRoom_id")
    private Long Id;

    @Column
    private String seatNumber;


    private LocalDateTime time;


    @OneToOne(mappedBy = "classRoom", fetch = LAZY)
    private Student student;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public static ClassRoom toclassRoom(SeatDto seatDto) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(seatDto.getId());
        classRoom.setSeatNumber(seatDto.getSeatNumber());
        classRoom.setTime(seatDto.getLocalDateTime());
        return classRoom;
    }


}
*/
