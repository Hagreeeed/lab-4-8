package Candy.types;

public enum CandyTypeForChocolet {
    MILK_CHOCOLATE("Milk Chocolate"),
    DARK_CHOCOLATE("Dark Chocolate"),
    WHITE_CHOCOLATE("White Chocolate"),
    FILLED_CHOCOLATE("Filled Chocolate");

    private String type;

    // Конструктор enum
    CandyTypeForChocolet(String type) {
        this.type = type;
    }

    // Метод для отримання текстового опису типу
    public String getType() {
        return type;
    }
}
