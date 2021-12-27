package com.parakramaba.simplespringboot.service;

import com.parakramaba.simplespringboot.dto.StudentExamDto;
import com.parakramaba.simplespringboot.exception.ResourceNotFoundException;
import com.parakramaba.simplespringboot.exception.ValidationException;
import com.parakramaba.simplespringboot.model.Exam;
import com.parakramaba.simplespringboot.model.Student;
import com.parakramaba.simplespringboot.model.StudentExam;
import com.parakramaba.simplespringboot.repository.ExamRepository;
import com.parakramaba.simplespringboot.repository.StudentExamRepository;
import com.parakramaba.simplespringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("StudentExamService")
public class StudentExamService {

    @Autowired
    private StudentExamRepository studentExamRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    public ResponseEntity<String> createStudentExam(StudentExamDto studentExamDto) {

        if(studentExamDto.getStudentId() == 0)
            throw new ValidationException("Student is required");
        if(studentExamDto.getStudentId() < 0)
            throw new ValidationException("Student id should be positive value");
        if(studentExamDto.getExamId() == 0)
            throw new ValidationException("Exam is required");
        if(studentExamDto.getExamId() < 0)
            throw new ValidationException("Exam id should be positive value");
        Student student = studentRepository.findById(studentExamDto.getStudentId()).orElseThrow(()->
                            new ResourceNotFoundException("Student not found : " + studentExamDto.getStudentId()));
        Exam exam = examRepository.findById(studentExamDto.getExamId()).orElseThrow(()->
                    new ResourceNotFoundException("Exam not found : " + studentExamDto.getExamId()));

        StudentExam studentExam =  new StudentExam();
        studentExam.setStudent(student);
        studentExam.setExam(exam);
        studentExam.setAppliedOn(studentExamDto.getAppliedOn());

        studentExamRepository.save(studentExam);

        return new ResponseEntity<>("Student exam have created successfully", HttpStatus.OK);
    }

    public ResponseEntity<?> getAllStudentExams() {
        if(studentExamRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("There are no records of student exams");
        }
        return new ResponseEntity<>(studentExamRepository.findAll(), HttpStatus.FOUND);
    }

}
