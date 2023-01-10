package CRUD;

import entity.CountyFlowerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Flower{

    static final Scanner scanner = new Scanner(System.in);

    public static EntityManager getEntity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }

    public static void showFlower(){
        Query query = getEntity().createQuery("SELECT c FROM CountyFlowerEntity c");
        List<CountyFlowerEntity> list = query.getResultList( );

        for (var l : list)
            System.out.println(l.getCountyFlowerName());
    }

    public static void createFlowerInput() {
        System.out.println("Namn: ");
        String name = scanner.nextLine();
        System.out.println("Färg: ");
        String colour = scanner.nextLine();
        System.out.println("Vilket landskap-id har landskapet som blomman tillhör?  0 för o se en lista på landskap");
        int countyID = Integer.parseInt(scanner.nextLine());

        if(countyID == 0){
            County.printCounties();
            System.out.println("Skriv id:");
            countyID = Parser.parseInput();
        }
        createFlower(name, colour, countyID);
    }

    public static void createFlower(String name, String colour, int countyID) {
        CountyFlowerEntity flower = new CountyFlowerEntity();
        flower.setCountyFlowerName(name);
        flower.setCountyFlowerColor(colour);
        flower.setMainCountyFlowerId(countyID);
        EntityS.addEntity(flower);

        System.out.println("Du har lagt till en ny blomma");
    }


    public static void updateFlowerInput() {
        System.out.println("Vilket landskap-id har landskapet som blomman tillhör?  0 för att se en lista på landskap");
        int countyID = Integer.parseInt(scanner.nextLine());

        if(countyID == 0){
            printFlowers();
            System.out.println("Skriv id:");
            countyID = Parser.parseInput();
        }
        System.out.println("Uppdaterat namn: ");
        String newName = scanner.nextLine();
        System.out.println("Uppdaterad färg: ");
        String newColour = scanner.nextLine();
        updateFlower(countyID, newName, newColour);
    }

    public static void updateFlower(int flowerID, String newName, String newColour){
        var entityManager = EntityS.getEntityManager();
        CountyFlowerEntity flower = entityManager.find(CountyFlowerEntity.class, flowerID);

        flower.setCountyFlowerName(newName);
        flower.setCountyFlowerColor(newColour);
        EntityS.updateEntity(flower);

        System.out.println("Blomman är uppdaterad.");


    }

    public static void deleteFlowerInput(){
        System.out.println("Vilket id har blomman du vill radera? 0 för att se en lista på blom-id");
        int flowerId = Parser.parseInput();
        if(flowerId == 0){
            printFlowers();
            System.out.println("Skriv id:");
            flowerId = Parser.parseInput();
        }
        deleteFlower(flowerId);

    }

    public static void deleteFlower(int countyFlowerId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CountyFlowerEntity flower = entityManager.find(CountyFlowerEntity.class, countyFlowerId);
        EntityS.deleteEntity(flower, entityManager);

        System.out.println("En blomma har tagits bort");

    }


    public static List<CountyFlowerEntity> getFlowers(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyFlowerEntity c");
        List <CountyFlowerEntity> list = query.getResultList( );

        return new ArrayList<>(list);
    }

    public static void printFlowers(){
        var entityManager = EntityS.getEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CountyFlowerEntity c");
        List<CountyFlowerEntity> list = query.getResultList();
        for (CountyFlowerEntity countyFlowerEntity : list) {
            System.out.println(countyFlowerEntity.getCountyFlowerId() + " - " + countyFlowerEntity.getCountyFlowerName());
        }
    }
}
