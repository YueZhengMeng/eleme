package com.shou.eleme.repository;

import com.shou.eleme.domain.OrderDetailet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDetailetRepository {
    @Insert("insert into orderdetailet(orderId,foodId,quantity) values(#{orderId},#{foodId},#{quantity})")
    void insertOrderDetailet(OrderDetailet orderDetailet);
}
