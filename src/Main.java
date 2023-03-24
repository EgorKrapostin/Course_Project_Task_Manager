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
        System.out.println("Выбери повторяемось: 1.Однократная, 2.Ежедневная, 3.Недельная, 4.Месячная, 5.Годовая");
        int occurance = scanner.nextInt();
        System.out.println("Введи название задачи");
        String title = scanner.next();
        System.out.println("Введи описание задачи");
        String description = scanner.next();

        Map<Integer, Task> taskMap = new HashMap<>();
        List<Task> removedTasks = new ArrayList<>();

        TaskService taskService = new TaskService(taskMap, removedTasks);
        taskService.addTask(taskService.createNewTask(occurance, title, description, input == 1 ? typeWork : typePersonal, LocalDate.of(2023, 3, 25)));
        taskService.getAllByDate();
    }
}