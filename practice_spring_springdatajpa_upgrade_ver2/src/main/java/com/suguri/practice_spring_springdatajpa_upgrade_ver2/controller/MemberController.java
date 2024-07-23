package com.suguri.practice_spring_springdatajpa_upgrade_ver2.controller;

import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.CommonErrorDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.CommonResDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain.MemberReqDto;
import com.suguri.practice_spring_springdatajpa_upgrade_ver2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/last")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member/create")
    public ResponseEntity<Object> memberCreate(@RequestBody MemberReqDto dto){
        try {
            CommonResDto commonResDto = new CommonResDto(HttpStatus.CREATED, "member is successfully created!", null);
            memberService.memberCreate(dto);
            return new ResponseEntity<>(commonResDto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(new CommonErrorDto(HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/member/list")
    public ResponseEntity<Object> memberList(){
        try{
            CommonResDto commonResDto = new CommonResDto(HttpStatus.OK, "member is successfully referred", memberService.memberList());
            return new ResponseEntity<>(commonResDto, HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(new CommonErrorDto(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/member/detail/{id}")
    public ResponseEntity<Object> memberDetail(@PathVariable Long id){
        try{
            CommonResDto commonResDto = new CommonResDto(HttpStatus.OK, "member is successfully referred", memberService.memberDetail(id));
            return new ResponseEntity<>(commonResDto, HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(new CommonErrorDto(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
