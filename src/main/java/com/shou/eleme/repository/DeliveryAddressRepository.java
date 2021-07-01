package com.shou.eleme.repository;

import com.shou.eleme.domain.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DeliveryAddressRepository {
    @Select("select daId from deliveryaddress where contactName=#{contactName} and contactSex=#{contactSex} and contactTel={contactTel} and address=#{address}")
    Integer selectDeliveryAddressId(DeliveryAddress deliveryAddress);
}
