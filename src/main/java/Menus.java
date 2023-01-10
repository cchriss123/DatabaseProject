import CRUD.*;

import java.util.Scanner;
public class Menus {
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        boolean isShowMenu = true;
        while (isShowMenu) {

            String menuText = """ 
                    1. Quiz
                    2. Crud
                    3. Leaderboard
                                        
                    e. Avsluta
                    """;
            System.out.println(menuText);

            switch (sc.nextLine()) {
                case "1" -> {
                    System.out.println("Skriv in antal frågor du vill ha på ditt quiz ");
                    Quiz.runQuiz(Parser.parseInput());
                }
                case "2" -> crudMenu();
                case "3" -> leaderBoardMenu();

                case "e", "E" -> {
                    isShowMenu = false;
                    System.out.println("Avslutar...");
                }
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void leaderBoardMenu() {
        boolean isShowMenu = true;
        while (isShowMenu) {

            String menuText = """ 
                    1. Show leaderboard
                    2. Reset leaderboard
                                        
                    e. Tillbaka till huvudmenyn
                    """;
            System.out.println(menuText);

            switch (sc.nextLine()) {
                case "1" -> {Leaderboard.printLeaderBoard();PressEnter.pressEnter();}
                case "2" -> {Leaderboard.resetBoardInput();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void crudMenu() {
        boolean isShowMenu = true;
        while (isShowMenu) {

            String menuText = """ 
                    1. Create
                    2. Read
                    3. Update
                    4. Delete
                    5. Count
                   
                                        
                    e Tillbaka till huvudmenyn
                    """;
            System.out.println(menuText);

            switch (sc.nextLine()) {
                case "1" -> createMenu();
                case "2" -> readMenu();
                case "3" -> updateMenu();
                case "4" -> deleteMenu();
                case "5" -> countMenu();
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void countMenu() {
        boolean isShowMenu = true;
        while (isShowMenu) {
            System.out.print("""
                    1. Antal städer med en befolkning över 50 000 invånare.
                    
                    e Tillbaka till CRUD menyn""");
            switch (sc.nextLine()) {
                case "1" -> {Count.countCityOverFiftyQuery();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void printChoiceMenu() {
        String menuText = """ 
                1. Landskap
                2. Blommor
                3. Kändisar
                4. Städer
                                    
                e Tillbaka till CRUD menyn
                """;

        System.out.println(menuText);
    }

    private static void readMenu() {
        boolean isShowMenu = true;
        while (isShowMenu) {
            printChoiceMenu();
            switch (sc.nextLine()) {
                case "1" -> {County.showCounty();PressEnter.pressEnter();}
                case "2" -> {Flower.showFlower();PressEnter.pressEnter();}
                case "3" -> {Celeb.readCeleb();PressEnter.pressEnter();}
                case "4" -> {City.readCity();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void deleteMenu() {
        boolean isShowMenu = true;
        while (isShowMenu){
            printChoiceMenu();
            switch (sc.nextLine()) {
                case "1" -> {County.deleteCountyInput();PressEnter.pressEnter();}
                case "2" -> {Flower.deleteFlowerInput();PressEnter.pressEnter();}
                case "3" -> {Celeb.deleteCelebInput();PressEnter.pressEnter();}
                case "4" -> {City.deleteCityInput();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void updateMenu() {
        boolean isShowMenu = true;
        while (isShowMenu){
            printChoiceMenu();
            switch (sc.nextLine()) {
                case "1" -> {County.updateCountyInput();PressEnter.pressEnter();}
                case "2" -> {Flower.updateFlowerInput();PressEnter.pressEnter();}
                case "3" -> {Celeb.updateCelebInput();PressEnter.pressEnter();}
                case "4" -> {City.updateCityInput();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }

    private static void createMenu() {
        boolean isShowMenu = true;
        while(isShowMenu){
            printChoiceMenu();
            switch (sc.nextLine()) {
                case "1" -> {County.inputNewCounty();PressEnter.pressEnter();}
                case "2" -> {Flower.createFlowerInput();PressEnter.pressEnter();}
                case "3" -> {Celeb.inputNewCeleb();PressEnter.pressEnter();}
                case "4" -> {City.createCityInput();PressEnter.pressEnter();}
                case "e", "E" -> isShowMenu = false;
                default -> System.out.println("Felaktigt val");
            }
        }
    }
}


