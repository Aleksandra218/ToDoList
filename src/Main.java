import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*
главный класс который создает объекты и запускает программу

здесь создаются все основные объекты а другие классы получают зависимости через конструктор.
в классе есть InputValidation конструктор и в меню тоже объект передается через конструктор

 */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputValidation validator = new InputValidation(scanner);


        Menu menu = new Menu(scanner, validator);
        menu.run();
    }
}