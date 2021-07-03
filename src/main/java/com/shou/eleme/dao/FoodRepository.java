package com.shou.eleme.dao;

import com.shou.eleme.po.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FoodRepository {
    @Select("select * from food where foodId=#{foodId}")
    Food selectFoodById(Integer foodId);

    @Select("select * from food where foodName=#{foodName} and businessId=#{businessId}")
    Food selectFoodByNameAndBus(String foodName,Integer businessId);

    @Select("select * from food where businessId=#{businessId}")
    List<Food> selectFoodByBusinessId(Integer businessId);

    @Select("select * from food")
    List<Food> selectAllFood();
}
