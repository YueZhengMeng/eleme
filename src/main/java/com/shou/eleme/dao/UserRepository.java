package com.shou.eleme.dao;

import com.shou.eleme.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Select("select * from user where userId=#{userId}")
    User selectUserById(String userId);

    @Select("select * from user where userName=#{userName}")
    User selectUserByName(String userName);

    @Insert("insert into user(userId,password,userName,phone,userSex,userImg) values(#{userId},#{password},#{userName},#{phone},#{userSex},#{userImg})")
    void insertNewUser(User user);

    @Update("update user set delTag=0 where userId=#{userId}")
    void banUser(String userId);

    @Update("update user set delTag=1 where userId=#{userId}")
    void unbanUser(String userId);
}
