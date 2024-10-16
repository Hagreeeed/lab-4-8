package Candy.types;

public enum CandyTypeForJally {
    FRUIT_JELLY("Fruit Jelly"),
    SOUR_JELLY("Sour Jelly"),
    GUMMY_BEARS("Gummy Bears");

    private String type;

    // Конструктор enum
    CandyTypeForJally(String type) {
        this.type = type;
    }

    // Метод для отримання текстового опису типу
    public String getType() {
        return type;
    }
}
