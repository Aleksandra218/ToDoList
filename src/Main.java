import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputValidation validator = new InputValidation(scanner);

        ToDoList toDoList = new ToDoList();

        Menu menu = new Menu(toDoList, validator);
        menu.run();
    }
}