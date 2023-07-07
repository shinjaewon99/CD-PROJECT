package com.study.nsuBoard.repository;


import com.study.nsuBoard.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public void save(Reservation reservation) {

        em.persist(reservation);
    }

    public Reservation findOne(Long id) {
        return em.find(Reservation.class, id);
    }

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();

    }

    public List<Reservation> findByReservationId(String seatNumber) {
        return em.createQuery("select r from Reservation r where r.seatNumber = :seatNumber", Reservation.class)
                .setParameter("seatNumber", seatNumber)
                .getResultList();

    }
}


