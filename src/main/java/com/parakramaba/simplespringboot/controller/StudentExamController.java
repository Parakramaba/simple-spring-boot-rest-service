package com.parakramaba.simplespringboot.controller;

import com.parakramaba.simplespringboot.dto.StudentDto;
import com.parakramaba.simplespringboot.exception.ResourceNotFoundException;
import com.parakramaba.simplespringboot.exception.ValidationException;
import com.parakramaba.simplespringboot.model.Student;
import com.parakramaba.simplespringboot.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-exam")
public class StudentExamController {

    @Autowired
    private StudentExamService studentExamService;

    @PostMapping("/students/save")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) throws ValidationException {
        return studentExamService.createStudent(studentDto);
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents() {
        return studentExamService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentExamService.getStudentById(id);
    }

    @GetMapping("/students/first-name")
    public ResponseEntity<?> getStudentsByFirstName(@RequestParam(name = "firstName") String firstName) throws ResourceNotFoundException {
        return studentExamService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/students/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam(name = "email") String email) throws ResourceNotFoundException {
        return studentExamService.getStudentByEmail(email);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto,@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentExamService.updateStudent(studentDto, id);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentExamService.deleteStudent(id);
    }

}
