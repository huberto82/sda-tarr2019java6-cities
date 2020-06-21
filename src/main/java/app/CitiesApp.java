package app;

import dao.CityDao;
import dao.CityDaoFile;
import service.CityService;
import service.CityServiceFile;

import java.io.IOException;

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
