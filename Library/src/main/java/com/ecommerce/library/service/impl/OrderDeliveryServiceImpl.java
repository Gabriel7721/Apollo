package com.ecommerce.library.service.impl;

import com.ecommerce.library.dto.OrderDeliveryDto;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDelivery;
import com.ecommerce.library.repository.OrderDeliveryRepository;
import com.ecommerce.library.repository.OrderRepository;
import com.ecommerce.library.service.OrderDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderDeliveryServiceImpl implements OrderDeliveryService {

    private final OrderDeliveryRepository orderDeliveryRepository;
    private final OrderRepository orderRepository;
    private OrderDelivery orderDelivery;

    @Override
    public OrderDelivery saveOrderDelivery(Order order, DeliveryPerson deliveryPerson) {
        Date date = new Date();
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setOrder(order);
        orderDelivery.setDeliveryPerson(deliveryPerson);
        orderDelivery.setStatus("Pending");
        orderDelivery.setAssignedDate(date);

        // Fetch the existing order from the database
        Order existingOrder = orderRepository.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Update only the deliveryDate field
        existingOrder.setDeliveryDate(date);

        // Save the updated order
        orderRepository.save(existingOrder);

        return orderDeliveryRepository.save(orderDelivery);
    }

    @Override
    public OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto) {
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setStatus(orderDeliveryDto.getStatus());
        return orderDeliveryRepository.save(orderDelivery);
    }
}
