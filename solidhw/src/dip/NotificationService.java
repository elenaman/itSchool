package dip;

public class NotificationService {

    private EmailNotifier emailNotifier = new EmailNotifier();

    public void notify(String message) {

        // validation and business logic here

        emailNotifier.sendEmail(message);
    }

}