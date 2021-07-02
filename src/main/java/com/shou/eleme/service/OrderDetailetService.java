package com.shou.eleme.service;

import com.shou.eleme.po.OrderDetailet;
import com.shou.eleme.dao.OrderDetailetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailetService {
    @Autowired
    OrderDetailetRepository orderDetailetRepository;

    void addOrderDetailet(OrderDetailet orderDetailet)
    {
        orderDetailetRepository.insertOrderDetailet(orderDetailet);
    }
}
