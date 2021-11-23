package com.parakramaba.simplespringboot.repository;

import com.parakramaba.simplespringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Optional<Student>> findAllByFirstName(String firstName);
    Optional<Student> findByEmail(String email);
}
