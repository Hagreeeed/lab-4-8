package commandInterface;
import Gift.Gift;
import Sweet.*;
import java.util.Scanner;

public class AddSweetCommand implements Command {
    private Gift gift;
    private Scanner scanner;

    public AddSweetCommand(Gift gift, Scanner scanner) {
        this.gift = gift;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter candy name: ");
        String name = scanner.next();
        System.out.print("Enter candy weight (grams): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter candy sugar content (grams): ");
        double sugarContent = scanner.nextDouble();

        // You can choose the type of candy dynamically as needed; here we use ChocolateCandy as an example
        Sweet newCandy = new ChocolateCandy(name, weight, sugarContent);
        gift.addSweet(newCandy);
        System.out.println("Candy added successfully!");
    }
}