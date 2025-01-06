package ex13;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birthdate (yyyy-mm-dd): ");
        String birthdateInput = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateInput);

        LocalDate today = LocalDate.now();

        if (birthdate.isAfter(today)) {
            System.out.println("Birthdate cannot be in the future!");
            return;
        }

        int years = today.getYear() - birthdate.getYear();
        int months = today.getMonthValue() - birthdate.getMonthValue();
        int days = today.getDayOfMonth() - birthdate.getDayOfMonth();

        if (days < 0) {
            months -= 1;
            days += birthdate.plusMonths(months + 1).lengthOfMonth(); // Days in the previous month
        }
        if (months < 0) {
            years -= 1;
            months += 12;
        }
        System.out.printf("You are %d years, %d months, and %d days old.%n", years, months, days);
        scanner.close();
    }
}
