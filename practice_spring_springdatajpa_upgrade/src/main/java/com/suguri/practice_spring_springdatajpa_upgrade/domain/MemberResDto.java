package com.suguri.practice_spring_springdatajpa_upgrade.domain;

import jdk.jfr.Name;
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
