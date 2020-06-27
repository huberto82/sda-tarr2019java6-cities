package mapper;

import model.City;

import java.util.Optional;
//Metoda nigdy nie powinna zwracać wartości null!!!
public class CityMapper {
    public static City mapFromGeonames(String line){
        String[] tokens = line.split("\t");
        //obsługujemy wyjątek błędu parsowania
        try {
            int id = Integer.parseInt(tokens[0]); //tu zgłaszanie wyjątku
            String name = tokens[1];
            double latitude = Double.parseDouble(tokens[4]);//tu zgłaszanie wyjątku
            double longitude = Double.parseDouble(tokens[5]);//tu zgłaszanie wyjątku
            String countryCode = tokens[8];
            int population = Integer.parseInt(tokens[14]);//tu zgłaszanie wyjątku
            return new City(id, name, latitude, longitude, countryCode, population);
        } catch (NumberFormatException e){
            //nie udało się parsowanie, zwracamy null zamiast obiektu City
            return null;
        }
    }
    //Zamiast wartości null należy stosować klasę Optional
    public static Optional<City> mapFromGeonamesOptional(String line){
        String[] tokens = line.split("\t");
        //obsługujemy wyjątek błędu parsowania
        try {
            int id = Integer.parseInt(tokens[0]); //tu zgłaszanie wyjątku
            String name = tokens[1];
            double latitude = Double.parseDouble(tokens[4]);//tu zgłaszanie wyjątku
            double longitude = Double.parseDouble(tokens[5]);//tu zgłaszanie wyjątku
            String countryCode = tokens[8];
            int population = Integer.parseInt(tokens[14]);//tu zgłaszanie wyjątku
            return Optional.of(new City(id, name, latitude, longitude, countryCode, population));
        } catch (NumberFormatException e){
            //nie udało się parsowanie, zwracamy null zamiast obiektu City
            return Optional.empty();
        }
    }
}
