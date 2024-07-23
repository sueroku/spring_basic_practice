package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
//@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
//    @OneToMany(mappedBy = "member")
//    private List<Post> posts;

    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MemberResDto listFromEntity(){
        return new MemberResDto(this.id, this.name, this.email);
    }

    public MemberDetResDto detailFromEntity(){
        LocalDateTime localDateTime = this.createdTime;
        String date = localDateTime.getYear() + "년" + localDateTime.getMonthValue() + "월" + localDateTime.getDayOfMonth() +"일";
        return new MemberDetResDto(this.id, this.name, this.email, this.password, date);
    }
}
