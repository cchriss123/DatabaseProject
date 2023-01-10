import CRUD.*;
import entity.CountyCelebEntity;
import entity.CountyCityEntity;
import entity.CountyFlowerEntity;
import entity.MainCountyEntity;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private final static Scanner scanner = new Scanner(System.in);

    private static int score;

    public static void runQuiz(int limit) {
        System.out.println("Skriv in ditt namn: ");
        var name = scanner.nextLine();

        var counties = County.getCounties();
        var celebs = Celeb.getCelebs();
        var flowers = Flower.getFlowers();
        var cities = City.getCities();

        score = 0;
        int roundsLeft = limit;

        while (0 < roundsLeft) {

            var roundScore = 6;
            var randomInt = getRandomint(counties);

            var correctAnswer = removeAndAddCounty(counties, randomInt);
            var cityName = removeAndAddCity(cities, randomInt);
            var celebName = removeAndAddName(celebs, randomInt);
            var flowerName = removeAndAddFlower(flowers, randomInt);

            if (!runFlowerQuestion(flowerName, correctAnswer)) {
                System.out.println("Tyvärr, du gissade fel. Här kommer nästa ledtråd!");
                roundScore -= 2;
                if (!runCelebQuestion(celebName, correctAnswer)) {
                    System.out.println("Tyvärr, du gissade fel. här kommer nästa ledtråd!");
                    roundScore -= 2;
                    if (!runCityQuestion(cityName, correctAnswer)) {
                        System.out.println("Tyvärr, inga fler ledtrådar. Du fick 0 poäng på frågan");
                        roundScore -= 2;
                    }
                }
            }
            score += roundScore;
            roundsLeft--;
        }
        System.out.println("Du lyckades skrapa ihop " + score + " av " + limit * 6 + " möjliga poäng!!");
        Leaderboard.createBoard(name, score);

    }

    private static boolean runCityQuestion(String cityName, String correctAnswer) {
        System.out.println("Vilket landskap ligger staden '" + cityName + "' i?");
        return runQuestion(correctAnswer);

    }

    private static boolean runCelebQuestion(String celebName, String correctAnswer) {
        System.out.println("Vilket landskap är '" + celebName + "' från?");
        return runQuestion(correctAnswer);
    }

    private static boolean runFlowerQuestion(String flowerName, String correctAnswer) {
        System.out.println("Vilket landskap har blomman '" + flowerName + "' som landskapsblomma?");
        return runQuestion(correctAnswer);
    }

    private static boolean runQuestion(String correctAnswer) {

        var guess = scanner.nextLine();
        if (guess.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Rätt gissning!");
            return true;
        }
        return false;
    }

    private static String removeAndAddCounty(List<MainCountyEntity> counties, int randomInt) {
        String correctAnswer = counties.get(randomInt).getMainCountyName();
        counties.remove(randomInt);

        return correctAnswer;
    }

    private static String removeAndAddCity(List<CountyCityEntity> cities, int randomInt) {
        String correctAnswer = cities.get(randomInt).getCountyCityName();
        cities.remove(randomInt);

        return correctAnswer;
    }

    private static String removeAndAddName(List<CountyCelebEntity> celebs, int randomInt) {
        String name = celebs.get(randomInt).getCountyCelebName();
        celebs.remove(randomInt);

        return name;
    }

    private static String removeAndAddFlower(List<CountyFlowerEntity> flowers, int randomInt) {
        String correctAnswer = flowers.get(randomInt).getCountyFlowerName();
        flowers.remove(randomInt);

        return correctAnswer;
    }

    private static int getRandomint(List<MainCountyEntity> counties) {
        return new Random().ints(0, counties.size()).findFirst().getAsInt();
    }

}
