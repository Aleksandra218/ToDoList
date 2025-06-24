import java.util.Scanner;

/*
 здесь класс работает со сканер считывает числа/строки и возвращает валидные данные
вроде как толькко этот класс будет работать со сканер или лучше сканер создать в мэйн?
тогда со сканером взаимодествие будет все равно через конструктор?
 */
public class InputValidation {
    Scanner scanner;

    public InputValidation(Scanner scanner) {
        this.scanner = scanner;
    }


    public int readMenuChoice() {
        System.out.print("Выберите действие: ");
        return validNumberMenu();
    }
    private int validNumberMenu() {
        while (true) {
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
