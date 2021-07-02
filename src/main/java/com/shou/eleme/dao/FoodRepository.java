package com.shou.eleme.dao;

import com.shou.eleme.po.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FoodRepository {
    @Select("select * from food where foodId=#{foodId}")
    Food selectFoodById(Integer foodId);
}
