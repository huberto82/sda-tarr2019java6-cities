package app;

import model.City;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Klasa pokazuje przykład kodu, którego nie można powtórnie wykorzystać, metoda main robi
 * wszystko, bez podziału na metody i klas, których odpowiedzialność jest ograniczona
 */
public class SimpleCitiesApp {
    static private List<City> cities;
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c:\\data\\cities500.txt");
        cities = Files.lines(path)
                .map(line -> {
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
                })
                .filter(city -> city != null) //przepuszczamy elementy różne od null
                .collect(Collectors.toList());
        //wyświetlenie miast polskich
        cities.stream().filter(city -> city.getCountryCode().equals("PL")).forEach(System.out::println);
        //wyświetl informacje o własnym mieście
        cities.stream().filter(city -> city.getName().equals("Toruń")).forEach(System.out::println);
        //Wyświetl polskie miasta zaczynajace się na literę T
        cities.stream().filter(city -> city.getCountryCode().equals("PL") && city.getName().startsWith("T")).forEach(System.out::println);
          //rozwlekły zapis operacji na strumieniu
//        Stream<String> li = Files.lines(path).map(line -> line);
//        Stream<String> fl = li.filter(l -> l!= null);
//        fl.forEach(System.out::println);
    }
}
