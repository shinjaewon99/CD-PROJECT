package com.study.nsuBoard.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    @Query("select new com.threefam.reserve.dto.reserve.ReserveItemSimpleDto(ri.id, ri.Hospital.hospitalName, ri.vaccineName, ri.reserveDate, ri.reserveTime, ri.status) " +
            "from ReserveItem  ri " +
            "where ri.user.id = :userId")
    Optional<ReserveItemSimpleDto> findByUserId(Long userId);

}


