package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.AbleTimeDto;

import java.util.List;

public interface ClassRoomService {


    List<AbleTimeDto> getAvailableTimes(Long id);
}
