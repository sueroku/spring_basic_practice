package com.suguri.practice_spring_springdatajpa_upgrade.service;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.Post;
import com.suguri.practice_spring_springdatajpa_upgrade.domain.PostResDto;
import com.suguri.practice_spring_springdatajpa_upgrade.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional(readOnly = true) // 이건 왜?
public class PostService {

    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResDto> postList(){
        List<PostResDto> postResDtos = new ArrayList<>();
        List<Post> posts = postRepository.findAll();
        for(Post p : posts){
            postResDtos.add(p.listFromEntity());
            System.out.println("author email : " + p.getMember().getEmail());
        }
        return postResDtos;
    }
}
