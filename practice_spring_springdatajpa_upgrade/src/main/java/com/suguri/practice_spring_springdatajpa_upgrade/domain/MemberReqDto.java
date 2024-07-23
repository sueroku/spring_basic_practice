package com.suguri.practice_spring_springdatajpa_upgrade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberReqDto {
    private String name;
    private String email;
    private String password;

    public Member toEntity(){
        return new Member(this.name, this.email, this.password);
    }
}
