package com.suguri.practice_spring_springdatajpa_ver.repository;

import com.suguri.practice_spring_springdatajpa_ver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    List<Member> findByName(String name);
}
