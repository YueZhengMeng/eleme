package com.shou.eleme.dao;

import com.shou.eleme.po.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartRepository {
    @Insert("insert into cart(foodId,businessId,userId,quantity) values(#{foodId},#{businessId},#{userId},#{quantity})")
    void insertCart(Cart cart);

    @Delete("delete from cart where cartId=#{cartId}")
    void deleteCart(Integer cartId);

    @Select("select * from cart where userId=#{userId} and businessId=#{businessId}")
    List<Cart> selectMyCart(String userId, Integer businessId);
}
