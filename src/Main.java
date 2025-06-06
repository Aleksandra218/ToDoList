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
                task = deleteTask(sc, task, completed, taskCount);
                taskCount--;
            } else if (choice == 5) {

            } else if (choice == 6) {
                System.out.println("Программа завершена! Всего доброго!");
            }
        }

    }
    private static String[] deleteTask(Scanner sc, String[] tasks, boolean[] completed, int taskCount) {
        System.out.print("Введите номер задачи для удаления: ");
        int taskNumber = validNumberTask(sc, taskCount);
        int indexToRemove = taskNumber - 1;

        // Создаём новый массив для задач
        String[] newTasks = new String[taskCount - 1];

        // 1. Копируем задачи до удаляемой
        if (indexToRemove > 0) {
            System.arraycopy(tasks, 0, newTasks, 0, indexToRemove);
        }

        // 2. Копируем задачи после удаляемой
        int elementsAfter = taskCount - indexToRemove - 1;
        if (elementsAfter > 0) {
            System.arraycopy(tasks, indexToRemove + 1, newTasks, indexToRemove, elementsAfter);
        }

        // 3. Обновляем массив completed
        if (taskCount - 1 > 0) {  // Проверяем, что остались элементы
            System.arraycopy(completed, 0, completed, 0, indexToRemove); // Копируем начало
            if (indexToRemove < taskCount - 1) {
                System.arraycopy(completed, indexToRemove + 1, completed, indexToRemove,
                        taskCount - indexToRemove - 1);
            }
            completed[taskCount - 1] = false; // Очищаем последний элемент
        }

        System.out.println("Задача " + taskNumber + " и отметка удалены!");
        return newTasks;
    }

    private static void markAsComplected(Scanner sc, String[] task, int taskCount, boolean[] completed) {
        if (taskCount == 0) { //если счетчик 0 то список пуст и завершаем метод
            System.out.println("Список задач пуст!");
            return;
        }
        printAllTask(task, taskCount, completed); // выводим список задач
        System.out.print("Введите номер задачи для отметки: ");

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
            if(newTask[i] == null){
                continue;
            }
            String status = completed[i] ? "\u001B[32m✔\u001B[0m" : "\u001B[31m✘\u001B[0m"; //
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