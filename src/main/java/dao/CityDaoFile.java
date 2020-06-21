package dao;

import model.City;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityDaoFile implements CityDao{
    private final List<City> cities;

    public CityDaoFile(String filePath){
        Path path = Paths.get(filePath);
        cities = Files.lines(path).map().filter().collect(Collectors.toList());
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public Optional<City> findById(int id) {
        return Optional.empty();
    }
}
