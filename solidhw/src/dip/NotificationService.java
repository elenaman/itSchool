package dip;

public class NotificationService {

    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {

        // validation and business logic here

        notifier.sendMessage(message);
    }

}