package dao;

import mapper.CityMapper;
import model.City;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityDaoFile implements CityDao{
    private final List<City> cities;

    public CityDaoFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        //Wykorzystanie metody mappera zwracającej null w przypadku niepoprawnego łańcucha opisującego miasto
//        cities = Files.lines(path)
//                .map(CityMapper::mapFromGeonames)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());

        //Wykorzystanie metody mappera zwracającej Optional
        cities = Files.lines(path)
                .map(CityMapper::mapFromGeonamesOptional)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<City> findAll() {
        //to tworzy kopię kolekcji, ale jest kiepskie wydajnościowo
        //return cities.stream().collect(Collectors.toList());
        //to jest ok pod względem wydajności, ale udostępniamy kolekcję na zewnątrz, i ktoś może ją wyczyścić!!!
        return cities;
    }

    @Override
    public Optional<City> findById(int id) {
        //Ten kod robi dokładnie to samo co ostatni wiersz ze strumieniem
//        for(City city: cities){
//            if (city.getId() == id){
//                return Optional.of(city);
//            }
//        }
//        return Optional.empty();
        return cities.stream().filter(city -> city.getId() == id).findAny();
    }
}
