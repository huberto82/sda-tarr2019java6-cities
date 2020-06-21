package service;

import dao.CityDao;
import model.City;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityServiceFile implements CityService{
    private final CityDao cityDao;

    public CityServiceFile(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> findByCountryCode(String countryCode) {
        return cityDao.findAll()
                .stream()
                .filter(city -> city.getCountryCode().equals(countryCode))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityDao.findAll()
                .stream()
                .filter(city -> city.getName().equals(name))
                .findAny();
    }

    @Override
    public List<City> findByNameStartWith(String startName) {
        //TODO samodzielnie zdefiniuj metodę
        return Collections.EMPTY_LIST;
    }
}
