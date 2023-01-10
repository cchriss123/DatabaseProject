package CRUD;

import entity.LeaderboardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class Leaderboard {

    public static void createBoard(String name, int points) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LeaderboardEntity leaderboard = new LeaderboardEntity();
        leaderboard.setLeaderBoardName(name);
        leaderboard.setLeaderBoardPoints(points);
        entityManager.persist(leaderboard);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public static void printLeaderBoard() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery
                ("SELECT l FROM LeaderboardEntity l ORDER BY l.leaderBoardPoints DESC LIMIT 10");

        List<LeaderboardEntity> list = query.getResultList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i).getLeaderBoardName() + " " + list.get(i).getLeaderBoardPoints());
        }
    }

    public static void resetBoardInput() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM LeaderboardEntity c");
        List<LeaderboardEntity> list = query.getResultList();

        for (LeaderboardEntity leaderboardEntity : list) {
            deleteBoard(leaderboardEntity.getLeaderboardId());
        }

    }

    public static void deleteBoard(int leaderBoardId) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        LeaderboardEntity board = entityManager.find(LeaderboardEntity.class, leaderBoardId);
        entityManager.remove(board);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Leaderboard har tagits bort.");
    }
}

