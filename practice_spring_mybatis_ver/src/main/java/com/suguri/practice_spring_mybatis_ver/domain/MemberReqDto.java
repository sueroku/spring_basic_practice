package com.suguri.practice_spring_mybatis_ver.domain;

import lombok.Data;

@Data
public class MemberReqDto {
    private String name;
    private String email;
    private String password;
}
