package Candy.candys;
import Candy.Candy;
import Candy.types.CandyTypeForChocolet;

public class ChocolateCandy extends Candy<CandyTypeForChocolet> {

    private CandyTypeForChocolet type;

    public ChocolateCandy(String name, int weight, int cost, int countSugar, CandyTypeForChocolet type) {
        super(name, weight, cost, countSugar);
        this.type = type;
    }

    @Override
    public void getInfo() {

    }
    public String getCandyType(){
        return type.getType();
    }
}
