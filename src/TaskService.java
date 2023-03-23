import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService {
    private Map<Integer, Task> taskMap;
    private Collection<Task> removedTasks;

    public TaskService(Map<Integer, Task> taskMap, Collection<Task> removedTasks) {
        this.taskMap = taskMap;
        this.removedTasks = removedTasks;
    }

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void removeTask(Task task) {
        removedTasks.add(task);
        taskMap.remove(task.getId());
    }

    private static boolean taskFilter(Task task) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = task.getDate();
        return date1.equals(date);
    }

    public void getAllByDate() {
        List<?> tasks = taskMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(TaskService::taskFilter)
                .collect(Collectors.toList());
        System.out.println(tasks);
    }

    @Override
    public String toString() {
        return "TaskService{" +
                "taskMap=" + taskMap +
                ", removedTasks=" + removedTasks +
                '}';
    }
}
