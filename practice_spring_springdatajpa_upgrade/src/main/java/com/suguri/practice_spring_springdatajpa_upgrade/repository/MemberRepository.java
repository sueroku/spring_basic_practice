package com.suguri.practice_spring_springdatajpa_upgrade.repository;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
