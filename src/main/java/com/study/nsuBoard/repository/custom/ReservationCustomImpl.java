package com.study.nsuBoard.repository.custom;

import com.study.nsuBoard.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationCustomImpl implements ReservationCustom{
    private final EntityManager em;

    @Override
    public List<Reservation> findAvailableTimesByAvailableDateId(Long id) {
        return em.createQuery(
                        "select t " +
                                "from Reservation  t "
                )

                .getResultList();
    }
}
