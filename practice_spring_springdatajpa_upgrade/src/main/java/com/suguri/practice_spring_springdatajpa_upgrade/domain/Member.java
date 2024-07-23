package com.suguri.practice_spring_springdatajpa_upgrade.domain;

//import lombok.AllArgsConstructor;
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
    @OneToMany(mappedBy = "member")
    private List<Post> posts;


    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MemberResDto listFromEntity(){
        return new MemberResDto(this.id, this.name, this.email);
    }

    public MemberDetResDto detFromEntity(){
        LocalDateTime createTime = this.getCreatedTime();
        String value  = createTime.getYear() + "년" + createTime.getMonthValue()+"월"+createTime.getDayOfMonth()+"일";
        return new MemberDetResDto(this.id, this.name, this.email, this.password, value);
    }

    public void pwUpdate(String password){
        this.password = password;
    }

}
