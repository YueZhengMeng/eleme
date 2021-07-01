package com.shou.eleme.service;

import com.shou.eleme.domain.DeliveryAddress;
import com.shou.eleme.repository.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryAddressService {
    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;

    public void addDeliveryAddress(DeliveryAddress deliveryAddress)
    {
        deliveryAddressRepository.insertDeliveryAddress(deliveryAddress);
    }
}