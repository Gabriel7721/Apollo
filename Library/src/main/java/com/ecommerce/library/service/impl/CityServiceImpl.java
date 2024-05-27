package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.City;
import com.ecommerce.library.model.Country;
import com.ecommerce.library.repository.CityRepository;
import com.ecommerce.library.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findByCountry(Country country) {
        return cityRepository.findByCountry(country);
    }

    @Override
    public List<City> findByCountryId(Long countryId) { // Implement this method
        return cityRepository.findByCountryId(countryId);
    }

}
