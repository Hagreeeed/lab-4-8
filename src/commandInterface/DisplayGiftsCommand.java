package commandInterface;

import Service.Service;

public class DisplayGiftsCommand implements Command {
    private final Service service;

    public DisplayGiftsCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.displayGifts();  // Викликаємо метод Service для відображення подарунків
    }

    @Override
    public String getDescription() {
        return "Display Gifts";
    }
}
