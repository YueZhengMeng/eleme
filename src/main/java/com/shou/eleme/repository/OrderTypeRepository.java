package com.shou.eleme.repository;

import com.shou.eleme.domain.OrderType;
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
