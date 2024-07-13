package com.suguri.practice_spring_mybatis_ver.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberRepository extends BasicRepository{
}
