//package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    @Column(length = 3000)
//    private String content;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//}
