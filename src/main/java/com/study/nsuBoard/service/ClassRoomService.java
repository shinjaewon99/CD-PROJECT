package com.study.nsuBoard.service;

import com.study.nsuBoard.entity.ClassRoom;
import com.study.nsuBoard.repository.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassRoomService {

    private ClassRoomRepository classRoomRepository;

    public String join(ClassRoom classRoom){
        classRoomRepository.save(classRoom);
        return classRoom.getNumber();
    }
}
