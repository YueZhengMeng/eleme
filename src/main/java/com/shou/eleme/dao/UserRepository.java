package com.shou.eleme.dao;

import com.shou.eleme.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Select("select * from user where userId=#{userId}")
    User selectUserById(String userId);
}
