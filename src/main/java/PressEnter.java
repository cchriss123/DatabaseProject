import java.util.Scanner;
public class PressEnter {
    private static Scanner scanner = new Scanner(System.in);

    public static void pressEnter() {
        System.out.println("\nPress \"ENTER\" to continue...");
        scanner.nextLine();
    }

}
