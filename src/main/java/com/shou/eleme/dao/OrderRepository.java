package com.shou.eleme.dao;

import com.shou.eleme.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderRepository {
    @Insert("insert into orders(userId,businessId,orderDate,orderTotal,daId,orderState) values(#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},#{orderState})")
    void insertNewOrder(Order order);

    @Select("select * from orders where userId=#{userId} and businessId = #{businessId} and orderState=0")
    Order selectMyOrder(String userId, int businessId);
}
