package Candy;

public abstract class Candy<C> {
    String name;
    private int weight;
    private int cost;
    private int countSugare;

    public Candy(String name, int weight, int cost, int countSugar) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.countSugare = countSugare;
    }

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCountSugare() {
        return countSugare;
    }


    public abstract void getInfo();
}
