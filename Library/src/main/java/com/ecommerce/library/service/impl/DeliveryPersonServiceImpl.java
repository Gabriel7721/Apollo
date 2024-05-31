package com.ecommerce.library.service.impl;

import com.ecommerce.library.dto.DeliveryPersonDto;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.repository.DeliveryPersonRepository;
import com.ecommerce.library.repository.RoleRepository;
import com.ecommerce.library.service.DeliveryPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;
    private final RoleRepository roleRepository;

    @Override
    public DeliveryPerson save(DeliveryPersonDto deliveryPersonDto) {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        deliveryPerson.setFirstName(deliveryPersonDto.getFirstName());
        deliveryPerson.setLastName(deliveryPersonDto.getLastName());
        deliveryPerson.setUsername(deliveryPersonDto.getUsername());
        deliveryPerson.setPassword(deliveryPersonDto.getPassword());
        deliveryPerson.setRoles(Arrays.asList(roleRepository.findByName("RIDER")));
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public DeliveryPerson findByUsername(String username) {
        return deliveryPersonRepository.findByUsername(username);
    }

    @Override
    public DeliveryPerson update(DeliveryPersonDto deliveryPersonDto) {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findByUsername(deliveryPersonDto.getUsername());
        deliveryPerson.setAddress(deliveryPersonDto.getAddress());
        deliveryPerson.setPhoneNumber(deliveryPersonDto.getPhoneNumber());
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public DeliveryPerson changePass(DeliveryPersonDto deliveryPersonDto) {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findByUsername(deliveryPersonDto.getUsername());
        deliveryPerson.setPassword(deliveryPersonDto.getPassword());
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public DeliveryPersonDto getDeliveryPerson(String username) {
        DeliveryPersonDto deliveryPersonDto = new DeliveryPersonDto();
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findByUsername(username);
        deliveryPersonDto.setFirstName(deliveryPerson.getFirstName());
        deliveryPersonDto.setLastName(deliveryPerson.getLastName());
        deliveryPersonDto.setUsername(deliveryPerson.getUsername());
        deliveryPersonDto.setPassword(deliveryPerson.getPassword());
        deliveryPersonDto.setAddress(deliveryPerson.getAddress());
        deliveryPersonDto.setPhoneNumber(deliveryPerson.getPhoneNumber());
        return deliveryPersonDto;
    }
}
