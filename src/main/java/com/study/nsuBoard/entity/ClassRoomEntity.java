package com.study.nsuBoard.entity;

import com.study.nsuBoard.dto.SeatDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String seatNumber;

    @Column
    private LocalDateTime time;
    public static ClassRoomEntity toclassRoomEntity(SeatDto seatDto){
        ClassRoomEntity classRoomEntity = new ClassRoomEntity();
        classRoomEntity.setId(seatDto.getId());
        classRoomEntity.setSeatNumber(seatDto.getSeatNumber());
        classRoomEntity.setTime(seatDto.getLocalDateTime());
        return classRoomEntity;
    }


}
