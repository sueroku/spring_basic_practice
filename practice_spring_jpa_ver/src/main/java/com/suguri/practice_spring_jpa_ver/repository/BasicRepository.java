package com.suguri.practice_spring_jpa_ver.repository;

import org.springframework.stereotype.Repository;
import com.suguri.practice_spring_jpa_ver.domain.Member;

import java.util.List;

@Repository
public interface BasicRepository{
    Member save(Member member);

    List<Member> findAll();

    Member findById(Long id);

}
