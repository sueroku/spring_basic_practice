package com.suguri.practice_spring_springdatajpa_upgrade.service;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.*;
import com.suguri.practice_spring_springdatajpa_upgrade.repository.MemberRepository;
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

    public List<MemberResDto> memberList(){
        List<MemberResDto> memberResDtos = new ArrayList<>();
        List<Member> members = memberRepository.findAll();
        for(Member m : members){
            memberResDtos.add(m.listFromEntity());
        }
        return memberResDtos;
    }

    public MemberDetResDto memberDetail(Long id){
        Optional<Member> optMember = memberRepository.findById(id);
        Member member = optMember.orElseThrow(()->new EntityNotFoundException("member is not found"));
        System.out.println("author's post : " + member.getPosts().size()); // 사실 글이 있는지 없는지도 따져줘야해!
        for(Post p : member.getPosts()){
            System.out.println(p.getId() + " post's title : " + p.getTitle());
        }
        return member.detFromEntity();
    }

    public void memberCreate(MemberReqDto dto){
        if(dto.getPassword().length()<=8){
            throw new IllegalArgumentException("password is too short.");
        }
        Member member = dto.toEntity();
        memberRepository.save(member);
    }

    public void pwUpdate(MemberPwUpdateDto dto){
        Member member = memberRepository.findById(dto.getId()).orElseThrow(()->new EntityNotFoundException("member is not found"));
        member.pwUpdate(dto.getPassword());
        memberRepository.save(member);
    }

    public void memberDelete(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()->new EntityNotFoundException("member is not found"));
        memberRepository.delete(member);
//        member.updateDelYN("Y"); // 일반적으로 이렇게 해용, 변수랑 메서드 만들어야해용
//        memberRepository.save(member);
    }
}
