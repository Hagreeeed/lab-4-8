package command;

import Present.Gift;

public class SortCandiesCommand implements Command {
    private Gift gift;

    public SortCandiesCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.sortByWeight();
        System.out.println("Candies sorted by weight.");
    }
}
