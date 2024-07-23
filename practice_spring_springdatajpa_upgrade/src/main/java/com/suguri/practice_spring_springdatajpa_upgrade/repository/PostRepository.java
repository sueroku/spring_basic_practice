package com.suguri.practice_spring_springdatajpa_upgrade.repository;

import com.suguri.practice_spring_springdatajpa_upgrade.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
