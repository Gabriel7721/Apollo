package com.ecommerce.delivery.config;

import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.repository.DeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class DeliveryServiceConfig implements UserDetailsService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findByUsername(username);
        if(deliveryPerson == null){
            throw new UsernameNotFoundException("Could not find username");
        }
        return new User(deliveryPerson.getUsername(),
                deliveryPerson.getPassword(),
                deliveryPerson.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }
}
