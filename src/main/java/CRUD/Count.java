package CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class Count {

    public static void countCityOverFiftyQuery(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT COUNT(c.countyCityPopulation) FROM CountyCityEntity c WHERE countyCityPopulation > 50000");

        System.out.println(query.getSingleResult());
        }
}


