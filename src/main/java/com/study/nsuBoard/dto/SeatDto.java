/*
package com.study.nsuBoard.dto;


import com.study.nsuBoard.entity.ClassRoom;
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

    public static SeatDto toSeatDto(ClassRoom classRoom){
        SeatDto seatDto = new SeatDto();
        seatDto.setId(classRoom.getId());
        seatDto.setSeatNumber(classRoom.getSeatNumber());
        seatDto.setLocalDateTime(classRoom.getTime());
        return seatDto;
    }

}
*/
