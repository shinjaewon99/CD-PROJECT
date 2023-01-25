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
    public String login() {
        Student student = new Student();
        List<Student> findStudents = studentRepository.findByStudentId(student.getStudent());
        String studentId = student.getStudent();
        for (Student findStudent : findStudents) {
            if (!(studentId == findStudent.getStudent())) {
                return null;
            }
        }

        return student.getStudent();
    }

}
