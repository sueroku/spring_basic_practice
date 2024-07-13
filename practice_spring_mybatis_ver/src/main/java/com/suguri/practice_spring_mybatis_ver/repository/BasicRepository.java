package com.suguri.practice_spring_mybatis_ver.repository;

import com.suguri.practice_spring_mybatis_ver.domain.Member;

import java.util.List;

public interface BasicRepository {
    Member save(Member member);

    List<Member> findAll();

    Member findById(Long id);
}
