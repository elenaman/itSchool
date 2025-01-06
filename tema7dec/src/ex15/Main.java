package ex15;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2025-01-06");

        String dayOfWeek = date.getDayOfWeek().toString();
        System.out.println(dayOfWeek);
    }
}
