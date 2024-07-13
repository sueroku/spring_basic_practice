package com.suguri.practice_spring_springdatajpa_ver.repository;

import com.suguri.practice_spring_springdatajpa_ver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
