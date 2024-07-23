package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberReqDto {

    private String name;
    private String email;
    private String password;

    public Member toEntity(){
        return new Member(this.name, this.email, this.password);
    }
}
