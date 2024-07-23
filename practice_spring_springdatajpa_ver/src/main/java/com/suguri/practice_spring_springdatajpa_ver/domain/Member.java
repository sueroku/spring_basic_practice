package com.suguri.practice_spring_springdatajpa_ver.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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


//    // 윈도우에 떠놓으면 기본적으로 스프링이 kst
//    // 리눅스는 기본적으로 utc // 시간 틀어지면 골치아프다..
//    @CreationTimestamp //  DB에는 current_timestamp가 생성되지 않음
//    private LocalDateTime createdTime; // 캐멀케이스 사용시 DB에는 _(언더바) 로 생성
//    @UpdateTimestamp
//    private LocalDateTime updateTime; //
}
