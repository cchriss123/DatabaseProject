package CRUD;

import entity.CountyCelebEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Celeb {

    private static Scanner scanner = new Scanner(System.in);

    public static EntityManager getEntity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }

    public static void inputNewCeleb() {
        System.out.println("Namn:");
        String name = scanner.nextLine();
        System.out.println("ålder:");
        int age = Parser.parseInput();
        System.out.println("Vilket landskap-id har landskapet som kändisen kommer från?  0 för o se en lista");

        int countyID = Parser.parseInput();

        if(countyID == 0){
            County.printCounties();
            System.out.println("Skriv id:");
            countyID = Parser.parseInput();
        }
        newCeleb(name, age, countyID);
    }

    public static void newCeleb(String name, int age, int countyID) {
        CountyCelebEntity celeb = new CountyCelebEntity();
        celeb.setCountyCelebName(name);
        celeb.setCountyCelebAge(age);
        celeb.setMainCountyCeleb(countyID);
        EntityS.addEntity(celeb);

        System.out.println("Kändisen är tillagd");
    }


    public static void readCeleb() {
        var query = getEntity().createQuery("SELECT c FROM CountyCelebEntity c");
        List<CountyCelebEntity> list = query.getResultList();

        for (CountyCelebEntity l : list) {
            System.out.print(l.getCountyCelebName());
            System.out.println("\t Ålder: " + l.getCountyCelebAge());
        }
    }


    public static void updateCelebInput() {
        System.out.println("Vilket landskap-id har landskapet som Kändisen tillhör? 0 för att se en lista på kändisar");
        int countyID = Integer.parseInt(scanner.nextLine());

        if(countyID == 0){
            printCelebs();
            System.out.println("Skriv id:");
            countyID = Parser.parseInput();
        }
        System.out.println("Uppdaterat namn: ");
        String newName = scanner.nextLine();
        System.out.println("Uppdaterad ålder: ");
        int newAge = Parser.parseInput();
        updateCeleb(countyID, newName, newAge);

    }

    public static void updateCeleb(int celebId, String newName, int newAge) {
        var entityManger = EntityS.getEntityManager();
        CountyCelebEntity celeb = entityManger.find(CountyCelebEntity.class, celebId);

        celeb.setCountyCelebName(newName);
        celeb.setCountyCelebAge(newAge);
        EntityS.updateEntity(celeb);

        System.out.println("kändisen är uppdaterad");
    }


    public static void deleteCelebInput() {
        System.out.println("Vilket id har kändisen du vill radera? 0 för att se en lista på kändis-id.");
        int celebID = Integer.parseInt(scanner.nextLine());

        if(celebID == 0){
            printCelebs();
            System.out.println("Skriv id:");
            celebID = Parser.parseInput();
        }

        deleteCeleb(celebID);

    }

    private static void deleteCeleb(int celebId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CountyCelebEntity celeb = entityManager.find(CountyCelebEntity.class, celebId);
        EntityS.deleteEntity(celeb, entityManager);

        System.out.println("En kändis har tagits bort");
    }

    public static List<CountyCelebEntity> getCelebs(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT c FROM CountyCelebEntity c");
        List <CountyCelebEntity> list = query.getResultList( );

        return new ArrayList<>(list);
    }
    public static void printCelebs(){
        var entityManager = EntityS.getEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyCelebEntity c");

        List<CountyCelebEntity> list = query.getResultList();

        for (CountyCelebEntity countyCelebEntity : list) {
            System.out.println(countyCelebEntity.getCountyCelebId() + " - " + countyCelebEntity.getCountyCelebName());
        }
    }
}

