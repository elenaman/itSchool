package isp;

public class PayPalProcessor implements PaymentProcessor{
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal Payment");
    }
}
