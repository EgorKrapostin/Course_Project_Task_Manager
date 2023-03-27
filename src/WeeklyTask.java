import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDate().plusWeeks(1));
    }
}
