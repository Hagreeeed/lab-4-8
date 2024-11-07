package SQLDataBase;
import java.sql.*;


public class DatabaseConnector implements AutoCloseable {
    private Connection connection;

    public DatabaseConnector(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void addGift(String giftName) throws SQLException {
        String query = "INSERT INTO Gifts (GiftName, TotalWeight) VALUES (?, 0)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, giftName);
            preparedStatement.executeUpdate();
            System.out.println("Gift added successfully!");
        }
    }

    public int getLatestGiftId() throws SQLException {
        String query = "SELECT TOP 1 GiftID FROM Gifts ORDER BY GiftID DESC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt("GiftID");
            } else {
                throw new SQLException("No gifts found in the database.");
            }
        }
    }


    public void addSweet(int giftId, String sweetName, double weight, double sugarContent) throws SQLException {
        String query = "INSERT INTO Sweets (GiftID, Name, Weight, SugarContent) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, giftId);
            preparedStatement.setString(2, sweetName);
            preparedStatement.setDouble(3, weight);
            preparedStatement.setDouble(4, sugarContent);
            preparedStatement.executeUpdate();
            System.out.println("Sweet added successfully!");
        }
        updateTotalWeight(giftId);
    }

    public void updateTotalWeight(int giftId) throws SQLException {
        String query = "UPDATE Gifts SET TotalWeight = (SELECT SUM(Weight) FROM Sweets WHERE GiftID = ?) WHERE GiftID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, giftId);
            preparedStatement.setInt(2, giftId);
            preparedStatement.executeUpdate();
            System.out.println("Total weight updated successfully!");
        }
    }

    public void displayGifts() throws SQLException {
        String query = "SELECT * FROM Gifts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("\n--- List of Gifts ---");
            while (resultSet.next()) {
                int giftId = resultSet.getInt("GiftID");
                String giftName = resultSet.getString("GiftName");
                double totalWeight = resultSet.getDouble("TotalWeight");
                System.out.println("Gift ID: " + giftId + ", Name: " + giftName + ", Total Weight: " + totalWeight + "g");
            }
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connection closed successfully.");
        }
    }
}