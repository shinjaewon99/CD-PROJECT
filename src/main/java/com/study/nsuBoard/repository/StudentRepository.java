package com.study.nsuBoard.repository;

import com.study.nsuBoard.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentRepository {


    private final EntityManager em;

    public void save(StudentEntity studentEntity) {
        em.persist(studentEntity);

    }


    public StudentEntity findOne(Long id) {
        return em.find(StudentEntity.class, id);
    }

    public List<StudentEntity> findByStudentId(String student) {
        return em.createQuery("select s from StudentEntity s where s.student = :student", StudentEntity.class)
                .setParameter("student", student)
                .getResultList();
    }


}
