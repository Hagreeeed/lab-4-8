package commandInterface;

import SQLDataBase.DatabaseConnector;
import java.sql.*;

public class DisplayGiftsCommand implements Command {
    private DatabaseConnector dbConnector;

    public DisplayGiftsCommand(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public void execute() {
        try {
            dbConnector.displayGifts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}