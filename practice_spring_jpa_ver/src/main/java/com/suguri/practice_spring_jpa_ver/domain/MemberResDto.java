package com.suguri.practice_spring_jpa_ver.domain;

import lombok.Data;

@Data
public class MemberResDto {
    private Long id;
    private String name;
    private String email;
}
