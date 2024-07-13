package com.suguri.practice_spring_jpa_ver.repository;

import com.suguri.practice_spring_jpa_ver.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MemberRepository implements BasicRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        return memberList;
    }

    @Override
    public Member findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return member;
    }
}
