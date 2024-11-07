import Gift.Gift;
import SQLDataBase.DatabaseConnector;
import Sweet.*;
import commandInterface.*;
import java.util.*;
import java.sql.*;

class NewYearGiftApp {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=NewYearGiftsDB;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "1234";

        try (Scanner scanner = new Scanner(System.in);
             DatabaseConnector dbConnector = new DatabaseConnector(url, user, password)) {
            boolean exit = false;

            // Create commands
            Command addGiftCommand = new AddGiftCommand(dbConnector, scanner);
            Command addSweetCommand = new AddSweetCommand(dbConnector, scanner);
            Command displayGiftsCommand = new DisplayGiftsCommand(dbConnector);

            // Menu using HashMap
            Map<Integer, Command> menu = new HashMap<>();
            menu.put(1, addGiftCommand);
            menu.put(2, addSweetCommand);
            menu.put(3, displayGiftsCommand);

            while (!exit) {
                // Displaying menu options
                System.out.println("\n--- New Year Gift Menu ---");
                System.out.println("1. Add a gift");
                System.out.println("2. Add a sweet to the latest gift");
                System.out.println("3. Display all gifts");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                if (choice == 4) {
                    exit = true;
                } else {
                    Command command = menu.get(choice);
                    if (command != null) {
                        command.execute();
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
