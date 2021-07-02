package com.shou.eleme.dao;

import com.shou.eleme.po.DeliveryAddress;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeliveryAddressRepository {
    @Select("select * from deliveryaddress where contactName=#{contactName} and contactSex=#{contactSex} and contactTel=#{contactTel} and address=#{address} and userId = #{userId}")
    DeliveryAddress selectDeliveryAddressId(DeliveryAddress deliveryAddress);

    @Insert("insert into deliveryaddress(contactName,contactSex,contactTel,address,userId) values(#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    void insertDeliveryAddress(DeliveryAddress deliveryAddress);

    @Select("select * from deliveryaddress where userId = #{userId}")
    List<DeliveryAddress> selectDeliveryAddressByUserId(String UserId);

    @Update("update deliveryaddress set contactName=#{contactName},contactSex=#{contactSex},contactTel=#{contactTel},address=#{address} where daId= #{daId}")
    void updateDeliveryAddress(DeliveryAddress deliveryAddress);

    @Delete("delete from deliveryaddress where daId= #{daId}")
    void deleteDeliveryAddress(int daId);
}
