package giftService;

import dao.GiftDao;
import java.sql.*;

public class GiftService implements AutoCloseable {
    private final GiftDao giftDao;

    public GiftService(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    // Додає новий подарунок
    public void addGift(String giftName) {
        try {
            giftDao.addGift(giftName); // Передаємо giftName у DAO
            System.out.println("Gift added successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to add gift: " + e.getMessage());
        }
    }


    // Отримує ID останнього подарунка
    public int getLatestGiftId() {
        try {
            return giftDao.getLatestGiftId();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Додає нові солодощі до подарунку та оновлює загальну вагу
    public void addSweet(int giftId, String sweetName, double weight, double sugarContent) {
        try {
            giftDao.addSweet(giftId, sweetName, weight, sugarContent);
            System.out.println("Sweet added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Виводить список подарунків
    public void displayGifts() {
        try {
            ResultSet rs = giftDao.displayGifts();
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
        giftDao.close();
    }
}
