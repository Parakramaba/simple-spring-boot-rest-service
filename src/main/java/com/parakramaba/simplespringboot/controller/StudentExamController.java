package com.parakramaba.simplespringboot.controller;

import com.parakramaba.simplespringboot.dto.StudentExamDto;
import com.parakramaba.simplespringboot.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-exam")
public class StudentExamController {

    @Autowired
    private StudentExamService studentExamService;

    @PostMapping("/new")
    public ResponseEntity<String> createStudentExam(@RequestBody StudentExamDto studentExamDto) {
        return studentExamService.createStudentExam(studentExamDto);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudentExams() {
        return studentExamService.getAllStudentExams();
    }

}
