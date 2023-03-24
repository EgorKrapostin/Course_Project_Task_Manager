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

    public Task createNewTask(int occurance, String title, String description, Task.Type type, LocalDate localDate) {
        Task task = null;
        switch (occurance) {
            case 1:
                task = new OneTimeTask(title, type, localDate, description);
                break;
            case 2:
                task = new DailyTask(title, type, localDate, description);
                break;
            case 3:
                task = new WeeklyTask(title, type, localDate, description);
                break;
            case 4:
                task = new MonthlyTask(title, type, localDate, description);
                break;
            case 5:
                task = new YearlyTask(title, type, localDate, description);
                break;
        }
        return task;
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
