package com.shou.eleme.dao;

import com.shou.eleme.po.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessRepository {
    @Select("select * from business where businessId=#{businessId}")
    Business selectBusinessById(Integer businessId);

    @Select("select * from business where businessName=#{businessName}")
    Business selectBusinessByName(String businessName);
}
