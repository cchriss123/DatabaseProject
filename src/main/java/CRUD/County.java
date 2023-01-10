package CRUD;

import entity.CountyCelebEntity;
import entity.CountyCityEntity;
import entity.CountyFlowerEntity;
import entity.MainCountyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class County {
    static final Scanner scanner = new Scanner(System.in);

    public static EntityManager getEntity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }

    public static void inputNewCounty() {
        System.out.println("Skriv in ditt nya landskap: ");
        String inputName = scanner.nextLine();
        newCounty(inputName);
    }

    public static void newCounty(String name) {
        MainCountyEntity county = new MainCountyEntity();
        county.setMainCountyName(name);
        EntityS.addEntity(county);

        System.out.println("Du har lagt till ett nytt landskap");
    }

    public static void showCounty() {
        var query = getEntity().createNamedQuery("showCounty");
        List<MainCountyEntity> list = query.getResultList();

        for (var l : list)
            System.out.println(l.getMainCountyName());

    }

    public static void updateCountyInput(){
        System.out.println("Vilket id har landskapet du vill uppdatera? 0 för att se lista på landskapen.");
        int mainCountyId = Parser.parseInput();
        if(mainCountyId == 0){
            printCounties();
            System.out.println("Skriv id:");
            mainCountyId = Parser.parseInput();
        }
        System.out.println("Uppdatera namn: ");
        String newCountyName = scanner.nextLine();
        updateCounty(mainCountyId,newCountyName );

    }

    public static void updateCounty(int mainCountyId, String newCountyName) {

        var entityManager = EntityS.getEntityManager();
        MainCountyEntity county = entityManager.find(MainCountyEntity.class, mainCountyId);

        county.setMainCountyName(newCountyName);
        EntityS.updateEntity(county);

        System.out.println("Landskapet är uppdaterat");

    }

    public static void deleteCountyInput() {
        System.out.println("Vilket id har landskapet du vill radera? 0 för att se lista på landskap.");
        int CountyId = Parser.parseInput();
        if(CountyId == 0){
            printCounties();
            System.out.println("Skriv id:");
            CountyId = Parser.parseInput();
        }
        deleteCounty(CountyId);

    }

    public static void deleteCounty(int mainCountyId) {
        prepareForCountyDelete(mainCountyId);
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        MainCountyEntity county = entityManager.find(MainCountyEntity.class, mainCountyId);
        EntityS.deleteEntity(county, entityManager);

        System.out.println("Ett landskap har tagits bort.");
    }

    private static void prepareForCountyDelete(int mainCountyId) {
        deleteCeleb(mainCountyId);
        deleteFlower(mainCountyId);
        deleteCity(mainCountyId);
    }

    private static void deleteCeleb(int mainCountyId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CountyCelebEntity celeb = entityManager.find(CountyCelebEntity.class, mainCountyId);
        EntityS.deleteEntity(celeb, entityManager);
    }

    private static void deleteFlower(int mainCountyId) {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        CountyFlowerEntity flower = entityManager.find(CountyFlowerEntity.class, mainCountyId);
        EntityS.deleteEntity(flower, entityManager);
    }

    private static void deleteCity(int mainCountyId) {
        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        CountyCityEntity city = entityManager.find(CountyCityEntity.class, mainCountyId);
        EntityS.deleteEntity(city, entityManager);
    }

    public static List<MainCountyEntity> getCounties() {
        var entityManager = EntityS.getEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM MainCountyEntity c");
        List<MainCountyEntity> list = query.getResultList();

        return new ArrayList<>(list);
    }

    public static void printCounties(){
        var entityManager = EntityS.getEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM MainCountyEntity c");
        List<MainCountyEntity> list = query.getResultList();
        for (MainCountyEntity mainCountyEntity : list) {
            System.out.println(mainCountyEntity.getMainCountyId() + " - " + mainCountyEntity.getMainCountyName());
        }
    }
}
