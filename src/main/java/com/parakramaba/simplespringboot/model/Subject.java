package com.parakramaba.simplespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "subjects")
public class Subject implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int code;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Exam> exams;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
