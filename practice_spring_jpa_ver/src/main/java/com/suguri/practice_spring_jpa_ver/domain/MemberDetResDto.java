package com.suguri.practice_spring_jpa_ver.domain;

import lombok.Data;

@Data
public class MemberDetResDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}
