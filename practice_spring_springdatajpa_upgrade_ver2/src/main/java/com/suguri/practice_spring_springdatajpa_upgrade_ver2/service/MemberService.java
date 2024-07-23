package com.suguri.practice_spring_springdatajpa_upgrade_ver2.service;

import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.Member;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.MemberDetResDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.MemberReqDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.MemberResDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberCreate(MemberReqDto dto){
        if(dto.getPassword().length()<=8){
            throw new IllegalArgumentException("password is too short!");
        }
        Member member = dto.toEntity();
        memberRepository.save(member);
    }

    public List<MemberResDto> memberList(){
        List<Member> members = memberRepository.findAll();
        if(members.isEmpty()){
            throw new EntityNotFoundException("members are not found");
        }
        List<MemberResDto> memberResDtos = new ArrayList<>();
        for(Member m : members){
            memberResDtos.add(m.listFromEntity());
        }
        return memberResDtos;
    }

    public MemberDetResDto memberDetail(Long id){
        Optional<Member> optMember = memberRepository.findById(id);
        Member member = optMember.orElseThrow(()->new EntityNotFoundException("member is not found"));
        return member.detailFromEntity();
    }
}
