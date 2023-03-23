import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, Type type, LocalDate date, String description) {
        super(title, type, date, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDate());
    }
}
