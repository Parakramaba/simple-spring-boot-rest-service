package com.parakramaba.simplespringboot.controller;

import com.parakramaba.simplespringboot.dto.StudentDto;
import com.parakramaba.simplespringboot.exception.ResourceNotFoundException;
import com.parakramaba.simplespringboot.exception.ValidationException;
import com.parakramaba.simplespringboot.model.Student;
import com.parakramaba.simplespringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/new")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) throws ValidationException {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping("/first-name")
    public ResponseEntity<?> getStudentsByFirstName(@RequestParam(name = "firstName") String firstName) throws ResourceNotFoundException {
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam(name = "email") String email) throws ResourceNotFoundException {
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto,@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentService.updateStudent(studentDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) throws ResourceNotFoundException {
        return studentService.deleteStudent(id);
    }

}
