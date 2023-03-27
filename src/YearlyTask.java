import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDate().plusYears(1));
    }
}
