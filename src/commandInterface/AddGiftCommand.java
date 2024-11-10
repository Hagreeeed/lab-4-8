package commandInterface;

import Service.Service;
import java.util.Scanner;

public class AddGiftCommand implements Command {
    private final Service service;
    private final Scanner scanner;

    public AddGiftCommand(Service service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter gift name: ");
        String giftName = scanner.nextLine();
        service.addGift(giftName);  // Викликаємо метод Service для додавання подарунка
    }

    @Override
    public String getDescription() {
        return "Add Gift";
    }
}
