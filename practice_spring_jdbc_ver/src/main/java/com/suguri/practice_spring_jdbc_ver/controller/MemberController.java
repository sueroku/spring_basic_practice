package com.suguri.practice_spring_jdbc_ver.controller;

import com.suguri.practice_spring_jdbc_ver.domain.MemberDetResDto;
import com.suguri.practice_spring_jdbc_ver.domain.MemberReqDto;
import com.suguri.practice_spring_jdbc_ver.domain.MemberResDto;
import com.suguri.practice_spring_jdbc_ver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
    public String home(){
        return "Member/home";
    }


    @GetMapping("/member/create")
    public String memberCreate(){
        return "Member/member-create";
    }
    @PostMapping("/member/create")
    public String memberCreatePost(MemberReqDto dto, Model model){
        try {
            memberService.memberCreate(dto);
            return "redirect:/member/list";
        }catch (IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
            return "Member/member-error";
        }
    }


    @GetMapping("/member/list")
    public String memberList(Model model){
        List<MemberResDto> memberResDtoList = memberService.memberList();
        model.addAttribute("memberList", memberResDtoList);
        return "Member/member-list";
    }


    @GetMapping("/member/detail/{id}")
    public String memberDetail(@PathVariable Long id, Model model){
        MemberDetResDto member = memberService.memberDetail(id);
        model.addAttribute("member", member);
        return "Member/member-detail";
    }


}
