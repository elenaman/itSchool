package dip;

public class SMSNotifier implements Notifier{
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent: " + message);
    }
}
