package bankkata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayDateProvider {
    public String todayString(){
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
