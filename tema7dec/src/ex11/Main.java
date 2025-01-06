package ex11;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first date (yyyy-mm-dd): ");
        String firstDateInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateInput);

        System.out.println("Enter the second date (yyyy-mm-dd): ");
        String secondDateInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateInput);

        if (firstDate.isAfter(secondDate)) {
            LocalDate temp = firstDate;
            firstDate = secondDate;
            secondDate = temp;
        }

        Period period = Period.between(firstDate, secondDate);

        System.out.println("Difference between the two dates:");
        System.out.println(period.getYears() + " years, " +
                period.getMonths() + " months, and " +
                period.getDays() + " days.");

        scanner.close();
    }
}
