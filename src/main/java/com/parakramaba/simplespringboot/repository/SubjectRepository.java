package com.parakramaba.simplespringboot.repository;

import com.parakramaba.simplespringboot.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
