package com.ecommerce.library.service;


import com.ecommerce.library.dto.DeliveryPersonDto;
import com.ecommerce.library.model.DeliveryPerson;

public interface DeliveryPersonService {
    DeliveryPerson save(DeliveryPersonDto deliveryPersonDto);

    DeliveryPerson findByUsername(String username);

    DeliveryPerson update(DeliveryPersonDto deliveryPersonDto);

    DeliveryPerson changePass(DeliveryPerson deliveryPersonDto);

    DeliveryPerson getDeliveryPerson(String username);

}
