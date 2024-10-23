import command.*;
import Present.Gift;
import Candy.candys.CaramelCandy;
import Candy.types.CandyTypeForCaramel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення подарунка
        Gift gift = new Gift();

        // Створення кількох цукерок
        CaramelCandy caramel1 = new CaramelCandy("Soft Caramel", 100, 15, 30, CandyTypeForCaramel.SOFT_CARAMEL);
        CaramelCandy caramel2 = new CaramelCandy("Hard Caramel", 150, 10, 25, CandyTypeForCaramel.HARD_CARAMEL);

        // Створення Invoker
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            // Виведення меню
            System.out.println("\nВиберіть дію:");
            System.out.println("1. Додати цукерку");
            System.out.println("2. Сортувати цукерки за вагою");
            System.out.println("3. Знайти цукерки за вмістом цукру");
            System.out.println("4. Показати всі цукерки");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Додавання цукерки
                    System.out.println("Виберіть цукерку для додавання:");
                    System.out.println("1. Soft Caramel");
                    System.out.println("2. Hard Caramel");
                    int candyChoice = scanner.nextInt();

                    Command addCandyCommand;
                    if (candyChoice == 1) {
                        addCandyCommand = new AddCandyCommand(gift, caramel1);
                    } else {
                        addCandyCommand = new AddCandyCommand(gift, caramel2);
                    }

                    invoker.setCommand(addCandyCommand);
                    invoker.executeCommand();
                    break;

                case 2:
                    // Сортування цукерок за вагою
                    Command sortCandiesCommand = new SortCandiesCommand(gift);
                    invoker.setCommand(sortCandiesCommand);
                    invoker.executeCommand();
                    break;

                case 3:
                    // Пошук цукерок за кількістю цукру
                    System.out.println("Введіть мінімальну кількість цукру:");
                    int minSugar = scanner.nextInt();
                    System.out.println("Введіть максимальну кількість цукру:");
                    int maxSugar = scanner.nextInt();

                    Command findCandiesCommand = new FindCandiesBySugarCommand(gift, minSugar, maxSugar);
                    invoker.setCommand(findCandiesCommand);
                    invoker.executeCommand();
                    break;

                case 4:
                    // Виведення інформації про всі цукерки
                    gift.displayCandiesInfo();
                    break;

                case 5:
                    // Вихід з програми
                    running = false;
                    System.out.println("Програма завершена.");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }

        scanner.close();
    }
}
