package com.suguri.practice_spring_springdatajpa_upgrade.controller;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.PostResDto;
import com.suguri.practice_spring_springdatajpa_upgrade.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/list")
    @ResponseBody
    public List<PostResDto> postList(){
        return postService.postList();
    }
}
