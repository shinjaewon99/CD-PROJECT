package com.study.nsuBoard.service;


import com.study.nsuBoard.entity.StudentEntity;
import com.study.nsuBoard.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Long join(StudentEntity studentEntity) {
        validateDuplicateStudentId(studentEntity);
        studentRepository.save(studentEntity);
        return studentEntity.getId();
    }

    private void validateDuplicateStudentId(StudentEntity studentEntity) {
        List<StudentEntity> findStudentIdEntity = studentRepository.findByStudentId(studentEntity.getStudent());
        if (!(findStudentIdEntity.isEmpty())) {
            throw new IllegalStateException("이미 등록된 학번입니다");
        }
    }

    public String login() {
        StudentEntity studentEntity = new StudentEntity();
        List<StudentEntity> findStudentEntities = studentRepository.findByStudentId(studentEntity.getStudent());
        String studentId = studentEntity.getStudent();
        for (StudentEntity findStudentEntity : findStudentEntities) {
            if (!(studentId == findStudentEntity.getStudent())) {
                return null;
            }
        }
        return studentEntity.getStudent();
    }
}
