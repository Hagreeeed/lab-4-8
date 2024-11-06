package commandInterface;
import Gift.Gift;
import Sweet.*;

import java.util.Comparator;



public class SortSweetsCommand implements Command {
    private Gift gift;
    private Comparator<Sweet> comparator;

    public SortSweetsCommand(Gift gift, Comparator<Sweet> comparator) {
        this.gift = gift;
        this.comparator = comparator;
    }

    @Override
    public void execute() {
        gift.sortSweets(comparator);
        System.out.println("Sweets sorted by sugar content.");
    }
}