package com.shou.eleme.dao;

import com.shou.eleme.po.DeliveryAddress;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DeliveryAddressRepository {
    @Select("select daId from deliveryaddress where contactName=#{contactName} and contactSex=#{contactSex} and contactTel=#{contactTel} and address=#{address}")
    Integer selectDeliveryAddressId(DeliveryAddress deliveryAddress);

    @Insert("insert into deliveryaddress(contactName,contactSex,contactTel,address,userId) values(#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    void insertDeliveryAddress(DeliveryAddress deliveryAddress);
}
