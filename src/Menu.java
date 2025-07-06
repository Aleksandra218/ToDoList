import java.util.Arrays;

public class Menu {
    private ToDoList toDoList; //создание переменной
    private InputValidation validator;

    public Menu(ToDoList toDoList, InputValidation validator) { //создание переменной
        this.toDoList = toDoList; //
        this.validator = validator;
    }

    public void run() {
        System.out.println("Добро пожаловать в консольный To Do List! ");
        while (true) {
            printMenu(); // печатаем меню

            int choiceMenu = InputValidation.validNumberMenu(); // выбор меню

            if (choiceMenu == 1) {
                toDoList.addTask();
            } else if (choiceMenu == 2) {
                toDoList.printAllTask();
            } else if (choiceMenu == 3) {
                toDoList.markAsComplected();
            } else if (choiceMenu == 4) {
                toDoList.deleteTask();
            } else if (choiceMenu == 5) {
                toDoList.findTask();
            } else if (choiceMenu == 6) {
                System.out.println("Программа завершена! Всего доброго!");
                return;
            }
        }
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


