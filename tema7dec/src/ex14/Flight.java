package ex14;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Flight {
    private final ZonedDateTime departureTime;
    private final ZonedDateTime arrivalTime;


    public Flight(ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getFlightDuration() {
        if (arrivalTime.isBefore(departureTime)) {
            return "Invalid flight times: Arrival time cannot be before departure time.";
        }

        Duration duration = Duration.between(departureTime, arrivalTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return String.format("%d hours and %d minutes", hours, minutes);
    }
}
