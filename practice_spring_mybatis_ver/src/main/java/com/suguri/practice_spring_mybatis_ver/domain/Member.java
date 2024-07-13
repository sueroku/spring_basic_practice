package com.suguri.practice_spring_mybatis_ver.domain;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;
}
