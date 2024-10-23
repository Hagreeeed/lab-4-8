package Present;

import Candy.Candy;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Gift {
    private List<Candy<?>> candies;

    // Конструктор
    public Gift() {
        this.candies = new ArrayList<>();
    }

    // Метод для додавання цукерок
    public void addCandy(Candy<?> candy) {
        candies.add(candy);
    }

    // Метод для розрахунку загальної ваги подарунка
    public int calculateTotalWeight() {
        int totalWeight = 0;
        for (Candy<?> candy : candies) {
            totalWeight += candy.getWeight();
        }
        return totalWeight;
    }

    // Метод для сортування цукерок за вагою
    public void sortByWeight() {
        candies.sort(Comparator.comparingInt(Candy::getWeight));
    }

    // Метод для пошуку цукерок за кількістю цукру в певному діапазоні
    public List<Candy<?>> findCandiesBySugarContent(int minSugar, int maxSugar) {
        List<Candy<?>> result = new ArrayList<>();
        for (Candy<?> candy : candies) {
            int sugar = candy.getCountSugare();
            if (sugar >= minSugar && sugar <= maxSugar) {
                result.add(candy);
            }
        }
        return result;
    }

    // Метод для виведення інформації про всі цукерки в подарунку
    public void displayCandiesInfo() {
        for (Candy<?> candy : candies) {
            candy.getInfo();
        }
    }
}
