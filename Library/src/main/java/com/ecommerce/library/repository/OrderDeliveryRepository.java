package com.ecommerce.library.repository;

import com.ecommerce.library.model.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, Integer> {
    OrderDelivery findOrderDeliveriesBy(Long id);
}
