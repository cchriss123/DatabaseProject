package CRUD;

import entity.CountyCityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class City {
    private static Scanner scanner = new Scanner(System.in);

    public static void createCityInput() {
        System.out.println("Namn på stad: ");
        String name = scanner.nextLine();
        System.out.println("Befolkningsmängd: ");
        int population = Integer.parseInt(scanner.nextLine());

        System.out.println("Vilket landskap-id har landskapet som staden ligger i?  0 för o se en lista på landskap");

        int county = Parser.parseInput();
        if(county == 0){
            County.printCounties();
            System.out.println("Skriv id:");
            county = Parser.parseInput();
        }
        createCity(name, population, county);
    }

    private static void createCity(String name, int population, int county) {
        CountyCityEntity city = new CountyCityEntity();
        city.setCountyCityName(name);
        city.setCountyCityPopulation(population);
        city.setMainCountyCity(county);
        EntityS.addEntity(city);

        System.out.println("Staden är tillagd!");
    }

    public static void readCity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyCityEntity c");

        List<CountyCityEntity> list = query.getResultList( );

        for (var l : list)
            System.out.println("'" + l.getCountyCityName() + "'");
    }


    public static void updateCityInput() {
        System.out.println("Vilket id har staden du vill uppdatera? 0 för att se en lista på städerna.");
        int CountyCityId = Parser.parseInput();
        if(CountyCityId == 0){
            printCities();
            System.out.println("Skriv id:");
            CountyCityId = Parser.parseInput();
        }
        System.out.println("Uppdaterad stad: ");
        String CountyCityName = scanner.nextLine();
        System.out.println("Uppdaterad befolkning: ");
        int newPopulation = Parser.parseInput();
        updateCity(CountyCityId, CountyCityName, newPopulation);

    }

    private static void updateCity(int countyCityId, String name, int newPopulation) {
        var entityManager = EntityS.getEntityManager();
        CountyCityEntity city = entityManager.find(CountyCityEntity.class, countyCityId);

        city.setCountyCityName(name);
        city.setCountyCityPopulation(newPopulation);
        EntityS.updateEntity(city);

        System.out.println("Staden är uppdaterad!");
    }

    public static void deleteCityInput() {
        System.out.println("Vilket id har staden du vill radera? 0 för att se lista på städer.");
        int cityId = Integer.parseInt(scanner.nextLine());

        if(cityId == 0){
            County.printCounties();
            System.out.println("Skriv id:");
            cityId = Parser.parseInput();
        }
        deleteCity(cityId);

    }

    private static void deleteCity(int cityId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CountyCityEntity city = entityManager.find(CountyCityEntity.class, cityId);
        EntityS.deleteEntity(city, entityManager);

        System.out.println("Staden har tagits bort");
    }


    public static List<CountyCityEntity> getCities(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyCityEntity c");
        List <CountyCityEntity> list = query.getResultList( );

        return new ArrayList<>(list);
    }
    public static void printCities(){
        var entityManager = EntityS.getEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyCityEntity c");
        List<CountyCityEntity> list = query.getResultList();
        for (CountyCityEntity countyCityEntity : list) {
            System.out.println(countyCityEntity.getCountyCityId() + " - " + countyCityEntity.getCountyCityName());
        }
    }
}
