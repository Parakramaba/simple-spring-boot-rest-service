package com.parakramaba.simplespringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    /*@Column(nullable = false)
    private long nic;*/

    @Column(nullable = false)
    private String email;

}
