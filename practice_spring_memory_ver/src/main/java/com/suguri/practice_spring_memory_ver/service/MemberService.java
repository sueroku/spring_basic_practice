package com.suguri.practice_spring_memory_ver.service;

import com.suguri.practice_spring_memory_ver.domain.Member;
import com.suguri.practice_spring_memory_ver.repository.BasicRepository;
import com.suguri.practice_spring_memory_ver.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final BasicRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberCreate(Member inputMember){
        if(inputMember.getPassword().length()<=8){
            throw new IllegalArgumentException("비밀번호가 짧습니다.");
        }
        Member member = new Member();
        member.setName(inputMember.getName());
        member.setEmail(inputMember.getEmail());
        member.setPassword(inputMember.getPassword());
        memberRepository.save(member);
    }

    public List<Member> memberList(){
        List<Member> member = memberRepository.findAll();
        return member;
    }

}
