import Gift.Gift;
import Sweet.*;
import commandInterface.*;
import java.util.*;


public class NewYearGift {
    public static void main(String[] args) {
        Gift gift = new Gift();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Creating commands
        Command addSweetCommand = new AddSweetCommand(gift, scanner);
        Command sortSweetsCommand = new SortSweetsCommand(gift, Comparator.comparingDouble(Sweet::getSugarContent));
        Command findSweetsCommand = new FindSweetsBySugarContentCommand(gift, 10, 35);

        // Creating a menu using HashMap
        Map<Integer, Command> menu = new HashMap<>();
        menu.put(1, addSweetCommand);
        menu.put(2, sortSweetsCommand);
        menu.put(3, findSweetsCommand);

        while (!exit) {
            // Displaying menu options
            System.out.println("\n--- New Year Gift Menu ---");
            System.out.println("1. Add a candy");
            System.out.println("2. Sort sweets by sugar content");
            System.out.println("3. Find sweets by sugar content range");
            System.out.println("4. Show total weight of the gift");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                exit = true;
            } else if (choice == 4) {
                // Display total weight
                System.out.println("Total weight of the gift: " + gift.getTotalWeight() + " grams");
            } else {
                Command command = menu.get(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }

        scanner.close();
    }
}