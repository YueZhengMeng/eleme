package com.shou.eleme.controller;

import com.shou.eleme.po.Food;
import com.shou.eleme.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Food> allFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Food getFoodById(@PathVariable Integer id) {
        return foodService.getFoodById(id);
    }
}
