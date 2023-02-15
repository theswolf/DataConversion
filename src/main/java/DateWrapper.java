import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class DateWrapper {

    private String timeZone;
    private Long dateNumber;


    public Date asDate() {
        Instant dateInstant = Instant.ofEpochMilli(getDateNumber());
        ZoneId zone = ZoneId.of(getTimeZone());
        return Date.from(ZonedDateTime.ofInstant(dateInstant,zone).toInstant());
    }

}
