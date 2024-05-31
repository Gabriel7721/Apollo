package com.ecommerce.library.service;


import com.ecommerce.library.dto.OrderDeliveryDto;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDelivery;

public interface OrderDeliveryService {
    OrderDelivery saveOrderDelivery(Order order, DeliveryPerson deliveryPerson);

    OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto);


}
