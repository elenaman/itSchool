package isp;

public class CreditCardProcessor implements PaymentProcessor{

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}
