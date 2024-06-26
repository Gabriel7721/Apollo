package com.ecommerce.library.service;

import com.ecommerce.library.model.City;
import com.ecommerce.library.model.Country;

import java.util.List;

public interface CityService {
    List<City> findAll();

    List<City> findByCountry(Country country);

    List<City> findByCountryId(Long countryId);
}
