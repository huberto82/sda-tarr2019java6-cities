package dao;

import model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    List<City> findAll();
    //Optional - klasa rodzaj pudełka na jeden element
    Optional<City> findById(int id);
    //powinny być metody typu save, delete, update
}
