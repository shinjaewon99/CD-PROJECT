package com.study.nsuBoard.entity;

import com.study.nsuBoard.status.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long Id;

    @Column
    private String seatNumber;


    @Column
    private String hour;

    @Column
    private String minute;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classroom_id")
    private ClassRoom classRoom;


    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


//    public static Reservation createReservation(Long id,
//                                                LocalDateTime startDate,
//                                                String seatNumber,
//                                                LocalDateTime endDate) {
//        Reservation reservation = new Reservation();
//        reservation.setId(id);
//        reservation.setSeatNumber(seatNumber);
//        reservation.setStartDate(startDate);
//        reservation.setEndDate(endDate);
//        return reservation;
//    }

}
