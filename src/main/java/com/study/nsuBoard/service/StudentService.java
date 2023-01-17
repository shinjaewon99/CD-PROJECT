package com.study.nsuBoard.service;


import com.study.nsuBoard.entity.Student;
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

    // 회원가입
    public Long join(Student student) {
        validateDuplicateStudentId(student);
        studentRepository.save(student);
        return student.getId();
    }

    private void validateDuplicateStudentId(Student student) {
        List<Student> findStudentId = studentRepository.findByStudentId(student.getStudent());
        if (!(findStudentId.isEmpty())) {
            throw new IllegalStateException("이미 등록된 학번입니다");
        }
    }


    // 로그인
    public String login(Student student) {
        List<Student> findStudent = studentRepository.findByStudentId(student.getStudent());
        Student findStudentId = studentRepository.findOne(student.getId());

        if(findStudent == null){
            System.out.println("학번이 없음");
        }
        if()


    }

}
