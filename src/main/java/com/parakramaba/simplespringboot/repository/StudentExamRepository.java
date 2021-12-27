package com.parakramaba.simplespringboot.repository;

import com.parakramaba.simplespringboot.model.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {

    Optional<List<StudentExam>> findByStudentId(long studentId);
}
