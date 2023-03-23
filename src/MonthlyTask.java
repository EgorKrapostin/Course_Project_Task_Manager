import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDate().plusMonths(1));
    }
}
