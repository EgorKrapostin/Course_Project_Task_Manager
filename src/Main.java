import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task.Type typeWork = Task.Type.WORK;
        Task.Type typePersonal = Task.Type.PERSONAL;
        System.out.println("Введи тип задачи (1.WORK/2.PERSOAL)");
        int input = scanner.nextInt();
        Task task = new OneTimeTask("onetime", input == 1 ? typeWork : typePersonal, LocalDate.now(), "OneTimeTask");
        Task task1 = new WeeklyTask("weekly", input == 1 ? typeWork : typePersonal, LocalDate.now().plusWeeks(1), "WeeklyTask");
        Task task2 = new MonthlyTask("monthly", input == 1 ? typeWork : typePersonal, LocalDate.now().plusMonths(1), "MonthlyTask");
        Task task3 = new YearlyTask("yearly", input == 1 ? typeWork : typePersonal, LocalDate.now().plusYears(1), "YearlyTask");
        Map<Integer, Task> taskMap = new HashMap<>();
        List<Task> removedTasks = new ArrayList<>();

        TaskService taskService = new TaskService(taskMap, removedTasks);
        taskService.addTask(task);
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        System.out.println(taskService);
        taskService.removeTask(task3);
        System.out.println(taskService);
        taskService.getAllByDate();
    }
}