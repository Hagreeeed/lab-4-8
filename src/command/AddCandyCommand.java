package command;

import Present.Gift;
import Candy.Candy;

public class AddCandyCommand implements Command {
    private Gift gift;
    private Candy<?> candy;

    public AddCandyCommand(Gift gift, Candy<?> candy) {
        this.gift = gift;
        this.candy = candy;
    }

    @Override
    public void execute() {
        gift.addCandy(candy);
        System.out.println("Candy added: " + candy.getName());
    }
}
