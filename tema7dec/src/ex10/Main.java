package ex10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Current date in dd-MM-yyyy format: " + now.format(format1));
        System.out.println("Current date in MM/dd/yyyy format: " + now.format(format2));
        System.out.println("Current date in yyyy/MM/dd format: " + now.format(format3));
        System.out.println("Current time in HH:mm:ss format: " + now.format(format4));
        System.out.println("Current date in full format: " + now.format(format5));
        System.out.println("Current date and time in dd-MM-yyyy HH:mm:ss format: " + now.format(format6));
    }
}
