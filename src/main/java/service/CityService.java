package service;

import model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findByCountryCode(String countryCode);
    Optional<City> findByName(String name);
    List<City> findByNameStartWith(String startName);
}
