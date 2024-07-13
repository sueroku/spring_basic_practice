package com.suguri.practice_spring_jpa_ver.service;

import com.suguri.practice_spring_jpa_ver.domain.Member;
import com.suguri.practice_spring_jpa_ver.domain.MemberDetResDto;
import com.suguri.practice_spring_jpa_ver.domain.MemberReqDto;
import com.suguri.practice_spring_jpa_ver.domain.MemberResDto;
import com.suguri.practice_spring_jpa_ver.repository.BasicRepository;
import com.suguri.practice_spring_jpa_ver.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MemberService {

    private final BasicRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void memberCreate(MemberReqDto dto){
        if(dto.getPassword().length()<=8){
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
        Member member = new Member();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPassword(dto.getPassword());
        memberRepository.save(member);
    }

    public MemberDetResDto memberDetail(Long id){
        Member member = memberRepository.findById(id);
        MemberDetResDto memberDetResDto = new MemberDetResDto();
        memberDetResDto.setId(member.getId());
        memberDetResDto.setName(member.getName());
        memberDetResDto.setEmail(member.getEmail());
        memberDetResDto.setPassword(member.getPassword());
        return memberDetResDto;
    }

    public List<MemberResDto> memberList(){
        List<MemberResDto> memberResDtos = new ArrayList<>();
        List<Member> members = memberRepository.findAll();
        for(Member m : members){
            MemberResDto memberResDto = new MemberResDto();
            memberResDto.setId(m.getId());
            memberResDto.setName(m.getName());
            memberResDto.setEmail(m.getEmail());
            memberResDtos.add(memberResDto);
        }
        return memberResDtos;
    }


}
