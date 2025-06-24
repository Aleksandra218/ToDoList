import java.util.Arrays;
import java.util.Scanner;
 /*
 класс работает с пользователем выводит меню и взаимодействует с классом берет корректные данные из
 класса InputValidation и работает c ToDoList

  */
public class Menu {
    private Scanner scanner;
    private InputValidation validator;

    public Menu(Scanner scanner, InputValidation validator) {
        this.scanner = scanner;
        this.validator = validator;
    }
    public void run() {
        System.out.println("Добро пожаловать в консольный To Do List! ");
//        while (true) {
            printMenu();
//
//            if (taskCount >= 1) {
//                completed = Arrays.copyOf(completed, taskCount);
//            }

            int choice = validator.readMenuChoice();
//
            if (choice == 1) {
//                if (arrayTask.length == taskCount) {
//                    arrayTask = Arrays.copyOf(arrayTask, taskCount + 1);
//                }
//                taskCount = addTask(sc, arrayTask, taskCount);
//                if (taskCount > 1) {
//                    arrayTask = sort(arrayTask, taskCount);
//                }
            }
//            } else if (choice == 2) {
//                printAllTask(arrayTask, taskCount, completed);
//            } else if (choice == 3) {
//                markAsComplected(sc, arrayTask, taskCount, completed);
//            } else if (choice == 4) {
//                int index = findIndexToRemove(sc, taskCount);
//                arrayTask = deleteTask(arrayTask, completed, taskCount, index);
//                completed = deleteComplected(completed, taskCount, index);
//                taskCount--;
//            } else if (choice == 5) {
//                findTask(sc, arrayTask, completed, taskCount);
//            } else if (choice == 6) {
//                System.out.println("Программа завершена! Всего доброго!");
//            }
//        }
    }

    private static void printMenu() {
        System.out.println("=== Меню ===\n" +
                "1. Добавить задачу\n" +
                "2. Показать все задачи\n" +
                "3. Отметить как выполненную\n" +
                "4. Удалить задачу\n" +
                "5. Найти задачу\n" +
                "6. Выход\n");
    }
}
