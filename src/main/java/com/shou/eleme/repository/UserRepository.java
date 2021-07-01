package com.shou.eleme.repository;

import com.shou.eleme.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Select("select * from user where userId=#{userId}")
    User selectUserById(String userId);
}
