package com.parakramaba.simplespringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String details;
}
