package com.study.nsuBoard.repository;

import com.study.nsuBoard.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentRepository {


    private final EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public Student findOne(Long id) {
        return em.find(Student.class, id);
    }

    public List<Student> findByStudentId(String student) {
        return em.createQuery("select s from Student s where s.student = :student", Student.class)
                .setParameter("student", student)
                .getResultList();

    }


}
