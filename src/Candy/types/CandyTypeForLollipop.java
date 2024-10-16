package Candy.types;

public enum CandyTypeForLollipop {
    FRUIT_LOLLIPOP("Fruit Lollipop"),
    SOUR_LOLLIPOP("Sour Lollipop"),
    FILLED_LOLLIPOP("Filled Lollipop");

    private String type;

    // Конструктор enum
    CandyTypeForLollipop(String type) {
        this.type = type;
    }

    // Метод для отримання текстового опису типу
    public String getType() {
        return type;
    }
}
