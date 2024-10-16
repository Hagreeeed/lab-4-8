package Candy.candys;

import Candy.Candy;
import Candy.types.CandyTypeForLollipop;

public class LollipopCandy extends Candy<CandyTypeForLollipop> {
    private CandyTypeForLollipop type;

    public LollipopCandy(String name, int weight, int cost, int countSugar, CandyTypeForLollipop type) {
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
