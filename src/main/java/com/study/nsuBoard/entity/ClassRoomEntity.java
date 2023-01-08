package com.study.nsuBoard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "classroom")
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private StudentEntity studentEntity;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;


    @Builder(builderMethodName = "createAvailableTime")

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
