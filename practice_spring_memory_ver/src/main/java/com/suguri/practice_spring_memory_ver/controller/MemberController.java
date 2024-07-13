package com.suguri.practice_spring_memory_ver.controller;

import com.suguri.practice_spring_memory_ver.domain.Member;
import com.suguri.practice_spring_memory_ver.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

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
    public String memberCreatePost(Member member, Model model){
        try {
            memberService.memberCreate(member);
            return "redirect:/";
        }catch (IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
            return "Member/member-error";
        }

    }


    @GetMapping("/member/list")
    public String memberList(Model model){
        List<Member> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
        return "Member/member-list";
    }
}
