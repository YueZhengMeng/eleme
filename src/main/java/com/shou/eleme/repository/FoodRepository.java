package com.shou.eleme.repository;

import com.shou.eleme.domain.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FoodRepository {
    @Select("select * from food where foodId=#{foodId}")
    Food selectFoodById(Integer foodId);
}
