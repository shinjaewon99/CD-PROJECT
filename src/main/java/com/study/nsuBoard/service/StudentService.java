package com.study.nsuBoard.service;


import com.study.nsuBoard.dto.StudentDto;
import com.study.nsuBoard.entity.StudentEntity;
import com.study.nsuBoard.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(StudentDto studentDto) {
        StudentEntity studentEntity = StudentEntity.toStudentEntity(studentDto);


        studentRepository.save(studentEntity);

    }

    // Db에 있으면 로그인 아직 구현 X
    public StudentDto login(StudentDto studentDto) {

        Optional<StudentEntity> byStudent = studentRepository.findByStudent(studentDto.getStudent());
        if (byStudent.isPresent()) {
            StudentEntity studentEntity = byStudent.get();
            if (studentEntity.getStudentPassword().equals(studentDto.getStudentPassword())) {
                StudentDto dto = StudentDto.toStudentDto(studentEntity);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
