package com.study.nsuBoard.repository;

import com.study.nsuBoard.dto.SeatDto;
import com.study.nsuBoard.entity.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<ClassRoomEntity, Long> {


    List<ClassRoomEntity> findByUserId(Long userId);

}


