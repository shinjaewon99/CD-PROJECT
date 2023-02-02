package com.study.nsuBoard.repository;

import com.study.nsuBoard.entity.ClassRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClassRoomRepository {
    private final EntityManager em;

    public void save(ClassRoom classRoom) {
        em.persist(classRoom.getNumber());
    }

    public Optional<List<ClassRoom>> findAll() {
        List<ClassRoom> result = em.createQuery("SELECT c FROM ClassRoom c", ClassRoom.class)
                .getResultList();
        return Optional.of(result);
    }

    public Optional<ClassRoom> findBydClassRoomId(Long ClassRoomId) {
        ClassRoom ClassRoom = em.find(ClassRoom.class, ClassRoomId);

        return ClassRoom == null ? Optional.empty() : Optional.of(ClassRoom);
    }
}
