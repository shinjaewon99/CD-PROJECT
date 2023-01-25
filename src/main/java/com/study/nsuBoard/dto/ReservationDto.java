package com.study.nsuBoard.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long classroomId;
    private String startDate;
    private String startHour;
    private String startMinute;
    private String endDate;
    private String endHour;
    private String endMinute;
}