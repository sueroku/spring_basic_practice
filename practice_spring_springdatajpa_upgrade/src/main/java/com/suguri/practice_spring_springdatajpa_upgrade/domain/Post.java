package com.suguri.practice_spring_springdatajpa_upgrade.domain;

//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
//@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public PostResDto listFromEntity(){
        return new PostResDto(this.id, this.title);
    }
}
