package com.shou.eleme.repository;

import com.shou.eleme.domain.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartRepository {
    @Insert("insert into cart(foodId,businessId,userId) values(#{foodId},#{businessId},#{userId})")
    void insertCart(Cart cart);

    @Delete("delete from cart where cartId=#{cartId}")
    void deleteCart(Integer cartId);

    @Select("select * from cart where userId=#{userId} and businessId=#{businessId}")
    List<Cart> selectMyCart(String userId, Integer businessId);
}
