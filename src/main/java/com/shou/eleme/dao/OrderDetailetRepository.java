package com.shou.eleme.dao;

import com.shou.eleme.po.OrderDetailet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailetRepository {
    @Insert("insert into orderdetailet(orderId,foodId,quantity) values(#{orderId},#{foodId},#{quantity})")
    void insertOrderDetailet(OrderDetailet orderDetailet);

    @Select("select * from orderdetailet where orderId=#{orderId}")
    List<OrderDetailet> selectOrderDetailetByOrderId(int orderId);
}
