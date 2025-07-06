import java.util.Scanner;

public class InputValidation {
    private static Scanner scanner;

    public InputValidation(Scanner scanner) {
        this.scanner = scanner;
    }


    public static String validKeyword() {
        String keyword = "";
        while (true) {
            keyword = scanner.nextLine().trim();
            if (keyword.isEmpty()) {
                System.out.print("Ошибка: ключевое слово не может быть пустым!");
                continue;
            }
            break;
        }
        return keyword;
    }

    public static int validNumberTask(int taskCount) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Ошибка: введите, пожалуйста целое число от 1 до " + taskCount + ": ");
                scanner.nextLine();
                continue;
            }
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 1 && number <= taskCount) {
                return number;
            } else {
                System.out.print("Ошибка: число вне диапазона. Введите, пожалуйста, число от 1 до " + taskCount + ": ");
                scanner.nextLine();
                continue;
            }
        }
    }

    public static String validTask() {
        String task = scanner.nextLine().trim(); //

        if (task.isEmpty()) { //
            System.out.print("Ошибка: задача не может быть пустой!"); //
            return null;
        }
        return task;
    }

    public static int validNumberMenu() {
        while (true) {
            System.out.print("Выберите действие: ");
            if (!scanner.hasNextInt()) {
                System.out.print("Ошибка: введите, пожалуйста, целое число от 1 до 6: ");
                scanner.nextLine();
                continue;
            }
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 1 && number <= 6) {
                return number;
            } else {
                System.out.print("Ошибка: число вне диапазона. Введите, пожалуйста, целое число от 1 до 6: ");
                scanner.nextLine();
                continue;
            }
        }
    }
}
