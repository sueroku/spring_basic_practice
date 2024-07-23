package com.suguri.practice_spring_springdatajpa_upgrade_ver2.repository;

import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
