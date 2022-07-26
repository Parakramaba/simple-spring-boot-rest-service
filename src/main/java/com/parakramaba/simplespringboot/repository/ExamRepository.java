package com.parakramaba.simplespringboot.repository;

import com.parakramaba.simplespringboot.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findAllByDate(Date date);
}