package com.suguri.practice_spring_memory_ver.repository;

import com.suguri.practice_spring_memory_ver.domain.Member;

import java.util.List;

public interface BasicRepository {
    Member save(Member member);

    // List 로 Member 객체를 전부 조회해서 돌려준다.
    // 배열보다 메서드가 덜 제한적이고, 자료구조는 똑같기 때문에 List 사용.
    List<Member> findAll();

    Member findById(Long id);
}
