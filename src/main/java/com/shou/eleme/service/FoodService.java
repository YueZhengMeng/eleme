package com.shou.eleme.service;

import com.shou.eleme.dao.FoodRepository;
import com.shou.eleme.po.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public List<Food> getBusinessFoods(Integer businessId) {
        return foodRepository.selectFoodByBusinessId(businessId);
    }

    public List<Food> getAllFoods() {
        return foodRepository.selectAllFood();
    }

    public Food getFoodById(Integer foodId) {
        return foodRepository.selectFoodById(foodId);
    }
}
