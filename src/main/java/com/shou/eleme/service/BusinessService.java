package com.shou.eleme.service;

import com.shou.eleme.dao.BusinessRepository;
import com.shou.eleme.dao.FoodRepository;
import com.shou.eleme.po.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusiness() {
        return businessRepository.selectAllBusiness();
    }

    public Business getBusinessById(Integer businessId) {
        return businessRepository.selectBusinessById(businessId);
    }
}
