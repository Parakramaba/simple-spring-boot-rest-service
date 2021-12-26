package com.parakramaba.simplespringboot.service;

import com.parakramaba.simplespringboot.dto.StudentDto;
import com.parakramaba.simplespringboot.exception.ResourceNotFoundException;
import com.parakramaba.simplespringboot.exception.ValidationException;
import com.parakramaba.simplespringboot.model.Student;
import com.parakramaba.simplespringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StudentService")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public ResponseEntity<?> createStudent(StudentDto studentDto) throws ValidationException {
        if(studentDto.getFirstName() == null || studentDto.getFirstName().length() == 0) {
            throw new ValidationException("First name is required");
        }
        if(studentDto.getLastName() == null || studentDto.getLastName().length() == 0) {
            throw new ValidationException("Last name is required");
        }
        if(studentDto.getEmail() == null || studentDto.getEmail().length() == 0) {
            throw new ValidationException("Email is required");
        }
        Optional<Student> existStudent = studentRepository.findByEmail(studentDto.getEmail());
        if(existStudent.isPresent()) {
            throw new ValidationException("Email already exists : " + studentDto.getEmail());
        }
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        studentRepository.save(student);
        return new ResponseEntity<>(studentDto,HttpStatus.CREATED);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<?> getStudentById(long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found : " + id)), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getStudentsByFirstName(String firstName) throws ResourceNotFoundException {
        List<Optional<Student>> studentOptional = studentRepository.findAllByFirstName(firstName);
        if(!studentOptional.isEmpty())
            return new ResponseEntity<>(studentOptional, HttpStatus.FOUND);
        else
            throw new ResourceNotFoundException("Student not found : " + firstName);
        /*return new  ResponseEntity<>(studentRepository.findAllByFirstName(firstName).orElseThrow(()->
                                new ResourceNotFoundException("Student not found : " + firstName)), HttpStatus.NOT_FOUND);*/
    }

    public ResponseEntity<?> getStudentByEmail(String email) throws ResourceNotFoundException {
        return new ResponseEntity<>(studentRepository.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException("Student not found : " + email)), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateStudent(StudentDto studentDto, long id) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found : " + id));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        studentRepository.save(student);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(long id) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Student not found : " + id)));
        studentRepository.deleteById(id);
        return new ResponseEntity<String>("Student is deleted : "+id, HttpStatus.OK);
    }

}
