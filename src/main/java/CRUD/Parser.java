package CRUD;

import java.util.Scanner;

public class Parser {

    private static final Scanner sc = new Scanner(System.in);
    public static int parseInput() {
        while (true){
            try {
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Var vänlig skriv in ett heltal.");
            }
        }
    }
}