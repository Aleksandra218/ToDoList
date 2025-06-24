import java.util.Arrays;
import java.util.Scanner;
/*
здесь будет управление задач : добавление удаление нахождение и т.д.
 */
public class ToDoList {
    Scanner scanner;

    String[] arrayTask = new String[10];





//    private static String[] sort(String[] task, int taskCount) {
//        task = getArrayNotNullTask(task, taskCount);
//        Arrays.sort(task);
//        return task;
//    }
//
//    private static void findTask(Scanner sc, String[] arrayTask, boolean[] complected, int taskCount) {
//        System.out.print("Введите ключевое слово: ");
//        String keyword = "";
//        arrayTask = getArrayNotNullTask(arrayTask, taskCount);
//        while (true) {
//            keyword = sc.nextLine().trim();
//            if (keyword.isEmpty()) {
//                System.out.println("Ошибка: ключевое слово не может быть пустым!");
//                continue;
//            }
//            break;
//        }
//        boolean isFound = false;
//        for (int i = 0; i < arrayTask.length; i++) {
//            if (arrayTask[i].toLowerCase().contains(keyword.toLowerCase())) {
//                if (!isFound) {
//                    System.out.println("Задачи найдены: ");
//                    isFound= true;
//                }
//                String status = getStatus(complected, i);
//                System.out.println((i + 1) + ". " + status + " " + arrayTask[i]);
//            }
//        }
//        if (!isFound) {
//            System.out.println("\"Задачи с ключевым словом \"" + keyword + "\" не найдены.\"");
//        }
//    }
//
//    private static String[] getArrayNotNullTask(String[] arrayTask, int taskCount) {
//        arrayTask = Arrays.copyOf(arrayTask, taskCount); //
//        return arrayTask;
//    }
//
//    private static int findIndexToRemove(Scanner sc, int taskCount) {
//        System.out.print("Введите номер задачи для удаления: ");
//        int taskNumber = validNumberTask(sc, taskCount);
//        return taskNumber - 1;
//    }
//
//    private static String[] deleteTask(String[] arrayTask, boolean[] completed, int taskCount, int indexToRemove) {
//        // Создаём новый массив для задач
//        String[] newTasks = new String[taskCount - 1];
//
//        // 1. Копируем задачи до удаляемой
//        if (indexToRemove > 0) {
//            System.arraycopy(arrayTask, 0, newTasks, 0, indexToRemove);
//        }
//        // 2. Копируем задачи после удаляемой
//        int elementsAfter = taskCount - indexToRemove - 1;
//        if (elementsAfter > 0) {
//            System.arraycopy(arrayTask, indexToRemove + 1, newTasks, indexToRemove, elementsAfter);
//        }
//        return newTasks;
//    }
//
//    private static boolean[] deleteComplected(boolean[] completed, int taskCount, int indexToRemove) {
//        boolean[] newComplected = new boolean[taskCount - 1];
//        int elementsAfter = taskCount - indexToRemove - 1;
//        // 1. Копируем задачи до удаляемой
//        if (indexToRemove > 0) {
//            System.arraycopy(completed, 0, newComplected, 0, indexToRemove);
//        }
//        // 2. Копируем задачи после удаляемой
//        int elementsAfterComplected = taskCount - indexToRemove - 1;
//        if (elementsAfterComplected > 0) {
//            System.arraycopy(completed, indexToRemove + 1, newComplected, indexToRemove, elementsAfter);
//        }
//        return newComplected;
//    }
//
//    private static boolean[] markAsComplected(Scanner sc, String[] arrayTask, int taskCount, boolean[] completed) {
//
//        //printAllTask(arrayTask, taskCount, completed); // выводим список задач
//        System.out.print("Введите номер задачи для отметки: ");
//
//        int taskNumber = validNumberTask(sc, taskCount); //считываем валидный номер
//
//        int index = taskNumber - 1;  // Индекс в массиве
//        completed[index] = true; //
//        System.out.println("Задача [" + taskNumber + "] отмечена как выполненная!"); //
//        return completed;
//    }
//
//    private static int validNumberTask(Scanner sc, int taskCount) {
//        while (true) {
//            if (!sc.hasNextInt()) {
//                System.out.println("Ошибка: введите, пожалуйста целое число от 1 до " + taskCount + ": ");
//                continue;
//            }
//            int number = sc.nextInt();
//            sc.nextLine();
//            if (number >= 1 && number <= taskCount) {
//                return number;
//            } else {
//                System.out.println("Ошибка: число вне диапазона. Введите, пожалуйста, число от 1 до " + taskCount + ": ");
//                sc.nextLine();
//                continue;
//            }
//        }
//    }
//
//    //вывод всех задач с нумерацией и статусом
//    private static void printAllTask(String[] arrayTask, int taskCount, boolean[] completed) {
//        if (taskCount == 0) { //
//            System.out.println("Список задач пуст!"); //
//            return;
//        }
//        System.out.println("Все задачи: "); //
//
//        for (int i = 0; i < arrayTask.length; i++) { //
//            String status = getStatus(completed, i);
//            System.out.println((i + 1) + ". " + status + " " + arrayTask[i]); //
//        }
//    }
//
//    private static String getStatus(boolean[] completed, int i) {
//        String status = completed[i] ? "\u001B[32m✔\u001B[0m" : "\u001B[31m✘\u001B[0m"; //
//        return status;
//    }
//
    private static int addTask(Scanner sc, String[] arrayTask, int taskCount) {
        while (true) {
            System.out.print("Введите задачу: "); //
            String task = sc.nextLine().trim(); //

            if (task.isEmpty()) { //
                System.out.println("Ошибка: задача не может быть пустой!"); //
                continue; //
            }

            boolean isDuplicate = false; //флаг для нахождения дубликата
            for (int i = 0; i < taskCount; i++) {
                if (arrayTask[i].equalsIgnoreCase(task)) {
                    System.out.println("Данная задача является дубликатом!");
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                continue; // Пропускаем дубликат
            }
            arrayTask[taskCount] = task;
            return taskCount + 1;
        }
    }
}
