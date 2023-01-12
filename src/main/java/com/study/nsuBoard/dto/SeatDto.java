package com.study.nsuBoard.dto;


import com.study.nsuBoard.entity.ClassRoomEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {

    private Long id;
    private String seatNumber;
    private LocalDateTime localDateTime;

    public static SeatDto toSeatDto(ClassRoomEntity classRoomEntity){
        SeatDto seatDto = new SeatDto();
        seatDto.setId(classRoomEntity.getId());
        seatDto.setSeatNumber(classRoomEntity.getSeatNumber());
        seatDto.setLocalDateTime(classRoomEntity.getTime());
        return seatDto;
    }

}
