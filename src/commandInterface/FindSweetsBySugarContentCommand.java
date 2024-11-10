package commandInterface;
import Gift.Gift;
import Sweet.*;
import java.util.List;

public class FindSweetsBySugarContentCommand implements Command {
    private Gift gift;
    private double minSugar;
    private double maxSugar;

    public FindSweetsBySugarContentCommand(Gift gift, double minSugar, double maxSugar) {
        this.gift = gift;
        this.minSugar = minSugar;
        this.maxSugar = maxSugar;
    }

    @Override
    public void execute() {
        List<Sweet> foundSweets = gift.findSweetsBySugarContent(minSugar, maxSugar);
        if (foundSweets.isEmpty()) {
            System.out.println("No sweets found within the given sugar content range.");
        } else {
            System.out.println("Sweets found:");
            for (Sweet sweet : foundSweets) {
                System.out.println(sweet.getName() + " - Sugar Content: " + sweet.getSugarContent() + "g");
            }
        }
    }

    @Override
    public String getDescription() {
        return "";
    }
}