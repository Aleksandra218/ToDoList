import java.util.Arrays;

/*
здесь будет управление задач : добавление удаление нахождение и т.д.
 */
public class ToDoList {
    private Tasks[] tasks;
    private int taskCount;

    public ToDoList() {
        tasks = new Tasks[10];
        taskCount = 0;

    }

        public void markAsComplected() {
        //printAllTask(arrayTask, taskCount, completed); // выводим список задач
        System.out.print("Введите номер задачи для отметки: ");

        int taskNumber = InputValidation.validNumberTask(taskCount); //считываем валидный номер

        int index = taskNumber - 1;  // Индекс в массиве
        tasks[index].setCompleted(true); //
        System.out.println("Задача [" + taskNumber + "] отмечена как выполненная!"); //

    }
    //    //вывод всех задач с нумерацией и статусом
    public void printAllTask() {
        System.out.println("Все задачи: ");

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i] != null) {
                System.out.println((i + 1) + ". " + tasks[i].toString());
            }
        }
    }

    public void addTask() {
        System.out.print("Введите задачу: "); //
        String task = InputValidation.validTask();

        if (!isDuplicate(task)) { // только если не дубликат
            tasks[taskCount] = new Tasks(task);
            System.out.println("Задача " + task + " добавлена в ячейку " + taskCount);
            taskCount++;
        }
    }

    public boolean isDuplicate(String task) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(task)) {
                System.out.println("Данная задача является дубликатом!");
                return true;
            }
        }
        return false;
    }
    public void sort() {

    }

    public void findTask() {
        System.out.print("Введите ключевое слово: ");
        String keyword = InputValidation.validKeyword();
        boolean isFound = false;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                if (!isFound) {
                    System.out.println("Задачи найдены: ");
                    isFound= true;
                }
                System.out.println((i + 1) + ". " + tasks[i].toString());
            }
        }
        if (!isFound) {
            System.out.println("\"Задачи с ключевым словом \"" + keyword + "\" не найдены.\"");
        }
    }

    public void deleteTask() {
        System.out.println("Введите номер задачи для удаления: ");
        int numberTask = InputValidation.validNumberTask(taskCount);
        int indexTask = numberTask - 1;
        System.arraycopy(tasks, numberTask, tasks, indexTask, taskCount - numberTask);
        tasks[4] = null;
        taskCount--;
    }
}
