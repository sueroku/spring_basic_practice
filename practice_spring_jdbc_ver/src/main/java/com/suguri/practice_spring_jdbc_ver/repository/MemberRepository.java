package com.suguri.practice_spring_jdbc_ver.repository;

import com.suguri.practice_spring_jdbc_ver.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository implements BasicRepository{

    @Autowired
    private DataSource dataSource;

    @Override
    public Member save(Member member) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into member(name, email, password) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from member";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Member member = new Member();
                member.setId(id);
                member.setName(name);
                member.setEmail(email);
                memberList.add(member);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return memberList;
    }


    @Override
    public Member findById(Long inputId) {
        Member member = new Member();
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from member where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, inputId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            member.setId(id);
            member.setName(name);
            member.setEmail(email);
            member.setPassword(password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return member;
    }
}
