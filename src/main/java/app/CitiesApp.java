package app;

import dao.CityDao;
import dao.CityDaoFile;
import service.CityService;
import service.CityServiceFile;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa programu, który działa dokładnie tak samo jak SimpleCitiesApp
 * ale wykorzystuje budowę zgodną z OOP i podział odpowiedzialności klas
 * Pakiety:
 * dao - pakiet Data Access Object: interfejs i klasa go implemetująca odpowiada za dostęp do danych
 * model - pakiet z klasą modelującą domenę, czyli opisuje miasto
 * mapper - pakiet zajmuje się mapowaniem łańcucha zawierającego opis miasta na klasę domenową
 * service - pakiet udostępniający usługi związane z domeną, czyli jakie operacje na miastach mają być dostępne w aplikacji
 */
public class CitiesApp {
    static final String filePath = "c:\\data\\cities500.txt";
    static private CityDao dao;
    static private CityService service;

    public static void main(String[] args) throws IOException {
        dao = new CityDaoFile(filePath);
        service = new CityServiceFile(dao);
        System.out.println(service.findByCountryCode("PL"));
        System.out.println(service.findByName("xxx"));
    }
}
