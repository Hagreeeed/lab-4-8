package commandInterface;
import Gift.Gift;
import SQLDataBase.DatabaseConnector;
import Sweet.*;
import java.util.Scanner;
import java.sql.*;

public class AddGiftCommand implements Command {
    private DatabaseConnector dbConnector;
    private Scanner scanner;

    public AddGiftCommand(DatabaseConnector dbConnector, Scanner scanner) {
        this.dbConnector = dbConnector;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter gift name: ");
            String giftName = scanner.next();
            dbConnector.addGift(giftName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}