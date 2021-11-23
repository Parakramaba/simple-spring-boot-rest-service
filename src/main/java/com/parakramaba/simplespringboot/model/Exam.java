package com.parakramaba.simplespringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int examType;

    @Column(nullable = false)
    private String subjectName;
}
