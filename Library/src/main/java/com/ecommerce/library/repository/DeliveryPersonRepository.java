package com.ecommerce.library.repository;

import com.ecommerce.library.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
    DeliveryPerson findByUsername(String username);
}
