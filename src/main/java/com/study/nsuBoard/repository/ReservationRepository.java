package com.study.nsuBoard.repository;


import com.study.nsuBoard.entity.Reservation;
import com.study.nsuBoard.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public void save(Reservation reservation){
//        Student student = new Student();
//        reservation.setStudent(student);
//        em.persist(student);
        em.persist(reservation);
    }
    public Reservation findOne(Long id) {
        return em.find(Reservation.class, id);
    }
    public List<Reservation> findAll(){
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();

    }
    public List<Reservation> findByReservationId(String seatNumber) {
        return em.createQuery("select r from Reservation r where r.seatNumber = :seatNumber", Reservation.class)
                .setParameter("seatNumber", seatNumber)
                .getResultList();

    }

   /* public Optional<List<Reservation>> findByBetweenDate(final LocalDateTime startDate, final LocalDateTime endDate) {
        List<Reservation> resultList = em.createQuery("SELECT r " +
                        "FROM Reservation r " +
                        "WHERE r.startDate BETWEEN :startDate AND :endDate " +
                        " OR r.endDate BETWEEN :startDate AND :endDate", Reservation.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();

        return resultList.size() == 0 ? Optional.empty() : Optional.of(resultList);
    }*/


}


