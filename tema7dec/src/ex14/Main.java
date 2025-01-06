package ex14;

import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        Flight fFlight = new Flight(ZonedDateTime.parse("2025-01-06T01:00:00-05:00[America/New_York]"), ZonedDateTime.parse("2025-01-06T14:30:00+01:00[Europe/Paris]"));
        System.out.println(fFlight.getFlightDuration());

    }
}
