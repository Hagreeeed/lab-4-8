package commandInterface;

import SQLDataBase.DatabaseConnector;

import java.util.Scanner;
import java.sql.*;

public class AddSweetCommand implements Command {
    private DatabaseConnector dbConnector;
    private Scanner scanner;

    public AddSweetCommand(DatabaseConnector dbConnector, Scanner scanner) {
        this.dbConnector = dbConnector;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            int giftId = dbConnector.getLatestGiftId();
            if (giftId == -1) {
                System.out.println("No gift found. Please add a gift first.");
                return;
            }
            System.out.print("Enter sweet name: ");
            String sweetName = scanner.next();
            System.out.print("Enter sweet weight (grams): ");
            double weight = scanner.nextDouble();
            System.out.print("Enter sweet sugar content (grams): ");
            double sugarContent = scanner.nextDouble();

            dbConnector.addSweet(giftId, sweetName, weight, sugarContent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}