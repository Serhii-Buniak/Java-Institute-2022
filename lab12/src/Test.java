import java.util.ArrayList;
import java.util.List;

public class Test {
    private int currentTask = -1;
    private List<Task> tasks = new ArrayList<Task>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Test(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task Next() {
        currentTask++;
        if (tasks.size() == currentTask) {
            return null;
        }
        Task task = tasks.get(currentTask);
        return task;
    }
}