package com.study.nsuBoard.service;

import com.study.nsuBoard.dto.ClassRoomDto;

import java.util.List;

public interface ClassRoomService {


    List<ClassRoomDto> getAvailableTime(Long classRoomId);
}
