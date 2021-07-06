package com.shou.eleme.service;

import com.shou.eleme.po.DeliveryAddress;
import com.shou.eleme.dao.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryAddressService {
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    public void addDeliveryAddress(DeliveryAddress deliveryAddress)
    {
        deliveryAddressRepository.insertDeliveryAddress(deliveryAddress);
    }

    public List<DeliveryAddress> getDeliveryAddressByUserId(String userId)
    {
        return deliveryAddressRepository.selectDeliveryAddressByUserId(userId);
    }

    public void changeDeliveryAddress(DeliveryAddress deliveryAddress)
    {
        deliveryAddressRepository.updateDeliveryAddress(deliveryAddress);
    }

    public void deleteDeliveryAddress(int daId)
    {
        deliveryAddressRepository.deleteDeliveryAddress(daId);
    }
}
