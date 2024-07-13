package com.suguri.practice_spring_memory_ver.repository;

import com.suguri.practice_spring_memory_ver.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository implements BasicRepository{

    private final List<Member> members;

    public MemberRepository() {
        members = new ArrayList<>();
    }

    @Override
    public Member save(Member member) {
        members.add(member);
        return null;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }
}
