package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.AbleTimeDto;
import com.study.nsuBoard.repository.AbleTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional

public class ClassRoomServiceImpl implements ClassRoomService {

    private final AbleTimeRepository ableTimeRepository;

    @Override
    public List<AbleTimeDto> getAvailableTimes(Long id) {
        return reserveItemRepository.findAvailableTimesByAvailableDateId(id)
                .stream().map(t -> new AvailableTimeDto(t.getId(), t.getTime())).collect(Collectors.toList());
    }
}
