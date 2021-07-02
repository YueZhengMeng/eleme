package com.shou.eleme.dao;

import com.shou.eleme.po.OrderType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderTypeRepository {
    @Select("select * from ordertype")
    List<OrderType> selectAllOrderTypes();
}
