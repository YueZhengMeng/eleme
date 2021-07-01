package com.shou.eleme.repository;

import com.shou.eleme.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderRepository {
    @Insert("insert into orders(userId,businessId) values(#{userId},#{businessId})")
    void insertNewOrder(Order order);

    @Select("select * from orders where userId=#{userId} and businessId = #{businessId} and orderState=0")
    Order selectMyOrder(String userId, int businessId);
}
