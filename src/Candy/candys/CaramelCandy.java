package Candy.candys;
import Candy.Candy;
import Candy.types.CandyTypeForCaramel;

public class CaramelCandy extends Candy<CandyTypeForCaramel> {
    private CandyTypeForCaramel candyType;

    public CaramelCandy(String name, int weight, int cost, int countSugar, CandyTypeForCaramel candyType) {
        super(name, weight, cost, countSugar);
        this.candyType = candyType;
    }

    @Override
    public void getInfo() {

    }
    public String getCandyType(){
        return candyType.getType();
    }
}
