
import SQLDataBase.DatabaseConnector;
import Service.Service;
import commandInterface.*;
import java.util.*;
import java.sql.*;

class NewYearGiftApp {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             DatabaseConnector connectorLink = new DatabaseConnector();
             Service dbConnector = new Service(connectorLink)) {

            Command addGiftCommand = new AddGiftCommand(dbConnector, scanner);
            Command addSweetCommand = new AddSweetCommand(dbConnector, scanner);
            Command displayGiftsCommand = new DisplayGiftsCommand(dbConnector);

            Map<Integer, Command> menu = new HashMap<>();
            menu.put(1, addGiftCommand);
            menu.put(2, addSweetCommand);
            menu.put(3, displayGiftsCommand);

            menuInterface(menu, scanner);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void menuInterface(Map<Integer, Command> menu, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- New Year Gift Menu ---");
            System.out.println("0. Exit");

            for (var element : menu.entrySet()) {
                System.out.println(element.getKey() + ". " + element.getValue().getDescription());
            }
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
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
    }
}
