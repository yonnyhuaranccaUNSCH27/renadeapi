package ipd.renade.renadeapi.exception;

import java.time.LocalDateTime;

public record CustomErrorRecord(
        LocalDateTime dateTime,
        String message,
        String details
) {

}
