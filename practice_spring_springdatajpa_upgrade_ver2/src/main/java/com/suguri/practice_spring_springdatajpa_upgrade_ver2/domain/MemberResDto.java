package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResDto {
    private Long id;
    private String name;
    private String email;
}
