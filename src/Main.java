import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] task = new String[15];
        boolean[] completed = new boolean[15];
        int taskCount = 0;

        System.out.println("Добро пожаловать в консольный To Do List! ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();

            int choice = readNumber(sc);

            if (choice == 1) {
                taskCount = addTask(sc, task, taskCount);
                System.out.println(Arrays.toString(task));
                System.out.println("Количество задач: " + taskCount);
            } else if (choice == 2) {
                printAllTask(task, taskCount, completed);
            } else if (choice == 3) {
                markAsComplected(sc, task, taskCount, completed);
            } else if (choice == 4) {
                task = deleteTask(sc, task, taskCount);
            } else if (choice == 5) {

            } else if (choice == 6) {
                System.out.println("Программа завершена! Всего доброго!");
            }
        }

    }
    private static String[] deleteTask(Scanner sc, String[] task, int taskCount) {
        System.out.print("Введите номер задачи для удаления: ");
        int numberTask = validNumberTask(sc, taskCount);
        int indexToRemove = numberTask - 1; // индекс в массиве (0-based)
        String[] beforeDeleteTask = Arrays.copyOfRange(task, 0, indexToRemove);; //от 0 до удаляемого, последний не входит
        String[] afterDeleteTask = Arrays.copyOfRange(task, indexToRemove + 1, taskCount);;
        String[] resultTask = new String[taskCount - 1];

        // Копируем beforeDeleteTask
        for (int i = 0; i < beforeDeleteTask.length; i++) {
            resultTask[i] = beforeDeleteTask[i];
        }

// Копируем afterDeleteTask
        for (int i = 0; i < afterDeleteTask.length; i++) {
            resultTask[beforeDeleteTask.length + i] = afterDeleteTask[i]; // важно: beforeDeleteTask.length + i
        }
        System.out.println("Задача " + numberTask + " удалена!");
        return resultTask;
    }

    private static void markAsComplected(Scanner sc, String[] task, int taskCount, boolean[] completed) {
        printAllTask(task, taskCount, completed); // выводим список задач
        if (taskCount == 0) { //если счетчик 0 то список пуст и завершаем метод
            System.out.println("Список задач пуст!");
            return;
        }
        System.out.println("Введите номер задачи для отметки: ");

        int taskNumber = validNumberTask(sc, taskCount); //считываем валидный номер

        int index = taskNumber - 1;  // Индекс в массиве
        completed[index] = true; //
        System.out.println("Задача [" + taskNumber + "] отмечена как выполненная!"); //
    }

    private static int validNumberTask(Scanner sc, int taskCount) {
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Ошибка: введите, пожалуйста целое число от 1 до " + taskCount + ": ");
                continue;
            }
            int number = sc.nextInt();
            sc.nextLine();
            if (number >= 1 && number <= taskCount) {
                return number;
            } else {
                System.out.println("Ошибка: число вне диапазона. Введите, пожалуйста, число от 1 до " + taskCount + ": ");
                sc.nextLine();
                continue;
            }
        }
    }

    //вывод всех задач с нумерацией и статусом
    private static void printAllTask(String[] task, int taskCount, boolean[] completed) {
        if (taskCount == 0) { //
            System.out.println("Список задач пуст!"); //
            return; //
        }
        String[] newTask = Arrays.copyOf(task, taskCount); //
        System.out.println("Все задачи: "); //
        for (int i = 0; i < newTask.length; i++) { //
            String status = completed[i] ? "\u001B[32m✓\u001B[0m" : "\u001B[31m✗\u001B[0m"; //
            System.out.println((i + 1) + ". " + status + " " + newTask[i]); //
        }
    }

    private static int addTask(Scanner sc, String[] task, int taskCount) {
        while (true) { //
            System.out.print("Введите задачу: "); //
            String input = sc.nextLine().trim(); //

            if (input.isEmpty()) { //
                System.out.println("Ошибка: задача не может быть пустой!"); //
                continue; //
            }
            System.out.println("Записываю задачу в ячейку " + taskCount + ": " + input); //
            task[taskCount] = input; //
            break; //
        }
        return taskCount + 1; //
    }

    private static int validNumberMenu(Scanner sc) {
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.print("Ошибка: введите, пожалуйста, целое число от 1 до 6: ");
                sc.nextLine();
                continue;
            }
            int number = sc.nextInt();
            sc.nextLine();
            if (number >= 1 && number <= 6) {
                return number;
            } else {
                System.out.print("Ошибка: число вне диапазона. Введите, пожалуйста, целое число от 1 до 6: ");
                sc.nextLine();
                continue;
            }
        }
    }

    private static int readNumber(Scanner sc) {
        System.out.print("Выберите действие: ");
        return validNumberMenu(sc);
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