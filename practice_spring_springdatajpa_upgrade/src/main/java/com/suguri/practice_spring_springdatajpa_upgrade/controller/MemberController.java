package com.suguri.practice_spring_springdatajpa_upgrade.controller;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.MemberDetResDto;
import com.suguri.practice_spring_springdatajpa_upgrade.domain.MemberReqDto;
import com.suguri.practice_spring_springdatajpa_upgrade.domain.MemberResDto;
import com.suguri.practice_spring_springdatajpa_upgrade.domain.MemberPwUpdateDto;
import com.suguri.practice_spring_springdatajpa_upgrade.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/upgrade")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/list")
    public List<MemberResDto> memberList(){
//        List<MemberResDto> memberResDtos = memberService.memberList();
        return memberService.memberList();
    }

    @GetMapping("/member/detail/{id}")
    public MemberDetResDto memberDetail(@PathVariable Long id){
        return memberService.memberDetail(id);
    }

    @PostMapping("/member/create")
    public String memberCreate(@RequestBody MemberReqDto dto){
        try {
            memberService.memberCreate(dto);
            return "ok";
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "error";
        }
    }

    @PatchMapping("/member/pw/update")
    public String memberPwUpdate(@RequestBody MemberPwUpdateDto dto){
        memberService.pwUpdate(dto);
        return "ok";
    }

    @DeleteMapping("/member/delete/{id}")
    public String memberDelete(@PathVariable Long id){
        memberService.memberDelete(id);
        return "ok";
    }
}
