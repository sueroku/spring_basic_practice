package com.suguri.practice_spring_springdatajpa_ver.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    private String password;
}
