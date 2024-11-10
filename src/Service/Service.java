package Service;

import SQLDataBase.DatabaseConnector;
import java.sql.*;

public class Service implements AutoCloseable {
    private final DatabaseConnector dbConnector;

    public Service(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    // Додає новий подарунок
    public void addGift(String giftName) {
        String query = "INSERT INTO Gifts (GiftName, TotalWeight) VALUES (?, 0)";
        try {
            dbConnector.executeUpdate(query, giftName);
            System.out.println("Gift added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримує ID останнього подарунка
    public int getLatestGiftId() {
        String query = "SELECT TOP 1 GiftID FROM Gifts ORDER BY GiftID DESC";
        try (ResultSet rs = dbConnector.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("GiftID");
            } else {
                throw new SQLException("No gifts found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Додає нові солодощі до подарунку та оновлює загальну вагу
    public void addSweet(int giftId, String sweetName, double weight, double sugarContent) {
        String query = "INSERT INTO Sweets (GiftID, Name, Weight, SugarContent) VALUES (?, ?, ?, ?)";
        try {
            dbConnector.executeUpdate(query, giftId, sweetName, weight, sugarContent);
            updateTotalWeight(giftId);
            System.out.println("Sweet added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Оновлює загальну вагу подарунку
    private void updateTotalWeight(int giftId) {
        String query = "UPDATE Gifts SET TotalWeight = (SELECT SUM(Weight) FROM Sweets WHERE GiftID = ?) WHERE GiftID = ?";
        try {
            dbConnector.executeUpdate(query, giftId, giftId);
            System.out.println("Total weight updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Виводить список подарунків
    public void displayGifts() {
        String query = "SELECT * FROM Gifts";
        try (ResultSet rs = dbConnector.executeQuery(query)) {
            System.out.println("\n--- List of Gifts ---");
            while (rs.next()) {
                int giftId = rs.getInt("GiftID");
                String giftName = rs.getString("GiftName");
                double totalWeight = rs.getDouble("TotalWeight");
                System.out.println("Gift ID: " + giftId + ", Name: " + giftName + ", Total Weight: " + totalWeight + "g");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        dbConnector.close();
    }
}

