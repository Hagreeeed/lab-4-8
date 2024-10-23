package command;

import Present.Gift;
import Candy.Candy;
import java.util.List;

public class FindCandiesBySugarCommand implements Command {
    private Gift gift;
    private int minSugar;
    private int maxSugar;

    public FindCandiesBySugarCommand(Gift gift, int minSugar, int maxSugar) {
        this.gift = gift;
        this.minSugar = minSugar;
        this.maxSugar = maxSugar;
    }

    @Override
    public void execute() {
        List<Candy<?>> foundCandies = gift.findCandiesBySugarContent(minSugar, maxSugar);
        System.out.println("Found candies with sugar content between " + minSugar + " and " + maxSugar + ":");
        for (Candy<?> candy : foundCandies) {
            System.out.println(candy.getName());
        }
    }
}
