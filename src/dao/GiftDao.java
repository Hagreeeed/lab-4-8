package dao;
import SQLDataBase.DatabaseConnector;
import java.sql.*;

public class GiftDao {
    private final DatabaseConnector dbConnector;

    public GiftDao(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    // Додає новий подарунок
    public void addGift(String giftName) throws SQLException {
        String query = "INSERT INTO Gifts (GiftName, TotalWeight) VALUES (?, 0)";
        dbConnector.executeUpdate(query, giftName); // Параметр giftName встановлюється у PreparedStatement
    }


    // Отримує ID останнього подарунка
    public int getLatestGiftId() throws SQLException {
        String query = "SELECT TOP 1 GiftID FROM Gifts ORDER BY GiftID DESC";
        try (ResultSet rs = dbConnector.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("GiftID");
            } else {
                throw new SQLException("No gifts found in the database.");
            }
        }
    }

    // Додає нові солодощі до подарунку та оновлює загальну вагу
    public void addSweet(int giftId, String sweetName, double weight, double sugarContent) throws SQLException {
        String query = "INSERT INTO Sweets (GiftID, Name, Weight, SugarContent) VALUES (?, ?, ?, ?)";
        dbConnector.executeUpdate(query, giftId, sweetName, weight, sugarContent);
        updateTotalWeight(giftId);
    }

    // Оновлює загальну вагу подарунку
    private void updateTotalWeight(int giftId) throws SQLException {
        String query = "UPDATE Gifts SET TotalWeight = (SELECT SUM(Weight) FROM Sweets WHERE GiftID = ?) WHERE GiftID = ?";
        dbConnector.executeUpdate(query, giftId, giftId);
    }

    // Виводить список подарунків
    public ResultSet displayGifts() throws SQLException {
        String query = "SELECT * FROM Gifts";
        return dbConnector.executeQuery(query);
    }

    public void close() {
    }
}
