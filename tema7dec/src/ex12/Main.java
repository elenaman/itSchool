package ex12;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime futureEventTime = LocalDateTime.of(2025, 1, 10, 15, 30);
        Event event = new Event(futureEventTime);

        System.out.println(event.calculateRemainingTime());
    }
}
