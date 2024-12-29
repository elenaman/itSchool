package dip;

/**
 * Refactor the NotificationService to depend on an abstraction.
 * Implement a new notifier for SMS without changing NotificationService.
 */
public class Main {
    public static void main(String[] args) {
        EmailNotifier emailNotifier = new EmailNotifier();
        SMSNotifier smsNotifier = new SMSNotifier();

        NotificationService notificationService = new NotificationService(emailNotifier);
        notificationService.notify("Email sent");

        notificationService.setNotifier(smsNotifier);
        notificationService.notify("SMS");

    }
}
