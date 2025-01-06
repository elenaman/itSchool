package ex12;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private final LocalDateTime eventTime;

    public Event(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String calculateRemainingTime(){
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, eventTime);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return days + " days, " +
                hours + " hours, " +
                minutes + " minutes, and " +
                seconds + " seconds.";
    }
}
