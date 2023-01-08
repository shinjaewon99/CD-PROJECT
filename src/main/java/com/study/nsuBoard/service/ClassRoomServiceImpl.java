package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.ClassRoomDto;
import com.study.nsuBoard.dto.SeatDto;
import com.study.nsuBoard.repository.BoardRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClassRoomServiceImpl implements ClassRoomService {

    private final BoardRepository boardRepository;

    public ClassRoomServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Override
    public List<SeatDto> getAvailableVaccineNameList(Long hospitalId) {
        return reserveItemRepository.findAvailableVaccines(hospitalId)
                .stream().map(v -> new VaccineReserveDto(v.getId(), v.getVaccineName())).collect(Collectors.toList());
    }

    @Override
    public List<ClassRoomDto> getAvailableTime(Long classRoomId) {
        return null;
    }
}
