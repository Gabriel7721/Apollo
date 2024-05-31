package com.ecommerce.library.service.impl;

import com.ecommerce.library.dto.OrderDeliveryDto;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDelivery;
import com.ecommerce.library.repository.OrderDeliveryRepository;
import com.ecommerce.library.service.OrderDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderDeliveryServiceImpl implements OrderDeliveryService {

    private final OrderDeliveryRepository orderDeliveryRepository;
    private OrderDelivery orderDelivery;

    @Override
    public OrderDelivery saveOrderDelivery(Order order, DeliveryPerson deliveryPerson) {
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setOrder(order);
        orderDelivery.setDeliveryPerson(deliveryPerson);
        orderDelivery.setAssignedDate(new Date());
        orderDelivery.setStatus("Pending");
        orderDelivery.setAccept(false);
        return orderDeliveryRepository.save(orderDelivery);
    }

    @Override
    public OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto) {
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setStatus(orderDeliveryDto.getStatus());
        return orderDeliveryRepository.save(orderDelivery);
    }
}
