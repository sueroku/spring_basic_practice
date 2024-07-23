package com.suguri.practice_spring_springdatajpa_upgrade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPwUpdateDto {
    private Long id;
    private String password;
}
