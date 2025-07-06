public class Tasks {

    private String tasks;
    private boolean completed;

    public Tasks(String task) {
        this.tasks = task;
        this.completed = false;

    }

    public String getName() {
        return tasks;
    }

    public boolean getCompleted() {
        return completed;
    }

    public boolean setCompleted(boolean completed) {
        return this.completed = completed;
    }

    public String getStatus() {
        String status = completed ? "\u001B[32m✔\u001B[0m" : "\u001B[31m✘\u001B[0m"; //
        return status;
    }

    @Override
    public String toString() {
        return getStatus() + " " + getName();
    }
}
