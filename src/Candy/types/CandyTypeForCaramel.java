package Candy.types;

public enum CandyTypeForCaramel {
    HARD_CARAMEL("Hard Caramel"),
    SOFT_CARAMEL("Soft Caramel"),
    SALTED_CARAMEL("Salted Caramel");

    private String type;

    // Конструктор enum
    CandyTypeForCaramel(String description) {
        this.type = type;
    }

    // Метод для отримання текстового опису типу
    public String getType() {
        return type;
    }
}
