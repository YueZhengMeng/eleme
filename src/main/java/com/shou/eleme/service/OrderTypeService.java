package com.shou.eleme.service;

import com.shou.eleme.dao.OrderTypeRepository;
import com.shou.eleme.po.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderTypeService {
    @Autowired
    OrderTypeRepository orderTypeRepository;

   public List<OrderType> getAllOrderTypes() {
        return orderTypeRepository.selectAllOrderTypes();
    }
}
