package Candy.candys;

import Candy.Candy;
import Candy.types.CandyTypeForJally;

public class JallyCandy extends Candy<CandyTypeForJally> {
    private CandyTypeForJally type;

    public JallyCandy(String name, int weight, int cost, int countSugar, CandyTypeForJally type) {
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
