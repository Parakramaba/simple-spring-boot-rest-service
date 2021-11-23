package com.parakramaba.simplespringboot.repository;

import com.parakramaba.simplespringboot.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}